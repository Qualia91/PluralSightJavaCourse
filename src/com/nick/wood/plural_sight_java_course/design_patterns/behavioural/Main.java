package com.nick.wood.plural_sight_java_course.design_patterns.behavioural;

import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.chain_of_responsibility.*;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.command.*;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.interpreter.AndExpression;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.interpreter.Expression;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.interpreter.OrExpression;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.interpreter.TerminalExpression;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.iterator.Repository;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.mediator.LightForMediatorPattern;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.mediator.Mediator;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.mediator.TurnOffAllLights;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.mediator.TurnOnAllLights;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.momento.Caretaker;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.momento.Employee;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.observer.MessageStream;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.observer.PhoneClient;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.observer.Subject;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.observer.TabletClient;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.state.Fan;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.strategy.AmexStrategy;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.strategy.CreditCard;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.strategy.VisaStrategy;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.template.OrderTemplate;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.template.StoreOrder;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.template.WebOrder;
import com.nick.wood.plural_sight_java_course.design_patterns.behavioural.visitor.*;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        testMethods();

    }

    static Expression buildInterpreterTree() {
        Expression terminal1 = new TerminalExpression("Lions");
        Expression terminal2 = new TerminalExpression("Tigers");
        Expression terminal3 = new TerminalExpression("Bears");

        // Tigers and bears
        Expression alteration1 = new AndExpression(terminal2, terminal3);

        // lions or (tigers and bears)
        Expression alteration2 = new OrExpression(terminal1, alteration1);

        // Bears and (lions or (tigers and bears))
        return new AndExpression(terminal3, alteration2);
    }

    private static void testMethods() {


        // using chain of responsibility
        Director director = new Director();
        VP vp = new VP();
        CEO ceo = new CEO();

        director.setSuccessor(vp);
        vp.setSuccessor(ceo);

        Request requestConf = new Request(RequestType.CONFERENCE, 500);
        Request requestCheapPurchase = new Request(RequestType.PURCHASE, 1000);
        Request requestExpensivePurchase = new Request(RequestType.PURCHASE, 2000);

        director.handleRequest(requestConf);
        director.handleRequest(requestCheapPurchase);
        director.handleRequest(requestExpensivePurchase);



        // using command
        Light light = new Light();
        Switch lightSwitch = new Switch();

        Command onCommand = new OnCommand(light);
        Command offCommand = new OffCommand(light);
        Command toggleCommand = new ToggleCommand(light);

        lightSwitch.execute(onCommand);
        lightSwitch.execute(offCommand);
        lightSwitch.undo();
        lightSwitch.undo();
        lightSwitch.undo();
        lightSwitch.execute(toggleCommand);
        lightSwitch.undo();
        lightSwitch.undo();



        // using interpreter
        String context1 = "Lions";
        String context2 = "Tigers";
        String context3 = "Bears";
        String context4 = "Lions Tigers";
        String context5 = "Lions Bears";
        String context6 = "Tigers Bears";

        Expression define = buildInterpreterTree();

        System.out.println(context1 + " is " + define.interpret(context1));
        System.out.println(context2 + " is " + define.interpret(context2));
        System.out.println(context3 + " is " + define.interpret(context3));
        System.out.println(context4 + " is " + define.interpret(context4));
        System.out.println(context5 + " is " + define.interpret(context5));
        System.out.println(context6 + " is " + define.interpret(context6));



        // using iterator
        Repository r = new Repository();

        r.add("A");
        r.add("B");
        r.add("C");

        Iterator<String> repoIterator = r.iterator();

        while (repoIterator.hasNext()) {
            System.out.println(repoIterator.next());
        }



        // mediator
        Mediator mediator = new Mediator();
        LightForMediatorPattern lightForMediatorPattern1 = new LightForMediatorPattern();
        LightForMediatorPattern lightForMediatorPattern2 = new LightForMediatorPattern();

        mediator.registerLight(lightForMediatorPattern1, lightForMediatorPattern2);

        com.nick.wood.plural_sight_java_course.design_patterns.behavioural.mediator.Command commandOn = new TurnOnAllLights(mediator);
        commandOn.execute();
        com.nick.wood.plural_sight_java_course.design_patterns.behavioural.mediator.Command commandOff = new TurnOffAllLights(mediator);
        commandOff.execute();



        // memento
        Caretaker caretaker = new Caretaker();
        Employee employee = new Employee("a", "b", "c");
        System.out.println(employee.toString());
        caretaker.save(employee);
        employee.setName("d");
        System.out.println(employee.toString());
        caretaker.revert(employee);
        System.out.println(employee.toString());
        employee.setName("d");
        caretaker.save(employee);
        employee.setName("e");
        System.out.println(employee.toString());
        caretaker.revert(employee);
        System.out.println(employee.toString());



        // observer
        Subject subject = new MessageStream();

        PhoneClient phoneClient = new PhoneClient(subject);
        TabletClient tabletClient = new TabletClient(subject);

        phoneClient.addMessage("New message from phone");
        tabletClient.addMessage("New message from tablet");



        // state
        Fan fan = new Fan();
        System.out.println(fan.toString());
        fan.pullChain();
        fan.pullChain();
        fan.pullChain();
        fan.pullChain();
        fan.pullChain();
        fan.pullChain();



        // strategy
        CreditCard ccAmex = new CreditCard(new AmexStrategy());
        ccAmex.setCvv("q");
        ccAmex.setDate("w");
        ccAmex.setNumber("379185883464283");
        System.out.println(ccAmex.isValid());
        CreditCard ccVisa = new CreditCard(new VisaStrategy());
        ccVisa.setCvv("q");
        ccVisa.setDate("w");
        ccVisa.setNumber("379185883464283");
        System.out.println(ccVisa.isValid());



        // template
        OrderTemplate webOrder = new WebOrder();
        webOrder.isGift = true;
        webOrder.process();
        OrderTemplate storeOrder = new StoreOrder();
        storeOrder.process();



        // visitor
        ConcreteElementOverall concreteElementOverall = new ConcreteElementOverall();

        Element concreteElementA = new ConcreteElementA();
        Element concreteElementB = new ConcreteElementB();
        Element concreteElementC = new ConcreteElementC();

        concreteElementOverall.getElements().add(concreteElementA);
        concreteElementOverall.getElements().add(concreteElementB);
        concreteElementOverall.getElements().add(concreteElementC);

        Visitor visitorA = new ConcreteVisitorA();
        concreteElementOverall.accept(visitorA);

        Visitor visitorB = new ConcreteVisitorB();
        concreteElementOverall.accept(visitorB);
    }
}

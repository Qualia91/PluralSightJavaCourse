package com.nick.wood.plural_sight_java_course.design_patterns.structural;

import com.nick.wood.plural_sight_java_course.design_patterns.structural.adapter.EmployeeClient;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.bridge.movie_printer_example.*;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.bridge.shape_example.*;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.bridge.shape_example.Shape;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.composite.Menu;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.composite.MenuItem;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.decorator.ConcreteComponent;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.decorator.ConcreteDecoratorA;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.decorator.ConcreteDecoratorB;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.facade.Address;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.facade.DbFacade;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.flyweight.StateCreator;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.proxy.SecurityProxy;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.proxy.TwitterService;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.proxy.TwitterServiceImpl;
import com.nick.wood.plural_sight_java_course.design_patterns.structural.proxy.TwitterServiceStub;

public class Main {

    public static void main(String[] args) {

        // using adapter
        EmployeeClient employeeClient = new EmployeeClient();
        System.out.println(employeeClient.getEmployeeList());

        // using bridge
        Colour blue = new Blue();
        Colour green = new Green();
        Colour red = new Red();
        Shape blueSquare = new Square(blue);
        Shape greenSquare = new Square(green);
        Shape redCircle = new Circle(red);

        blueSquare.applyColour();
        greenSquare.applyColour();
        redCircle.applyColour();

        Movie movie = new Movie();
        movie.setClassification("A");
        movie.setRuntime("B");
        movie.setTitle("C");
        movie.setYear("D");

        Formatter printFormatter = new PrintFormatter();
        Formatter htmlFormatter = new HtmlFormatter();
        Printer printer = new MoviePrinter(movie);
        System.out.println(printer.print(printFormatter));
        System.out.println(printer.print(htmlFormatter));


        // using composite
        Menu mainMenu = new Menu("Main", "/main");
        MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");
        mainMenu.add(safetyMenuItem);
        Menu claimsSubMenu = new Menu("Claims", "/claims");
        mainMenu.add(claimsSubMenu);
        MenuItem personalClaimsMenuItem = new MenuItem("Personal Claim", "/personalClaim");
        claimsSubMenu.add(personalClaimsMenuItem);
        Menu otherSubMenu = new Menu("Other", "/other");
        mainMenu.add(otherSubMenu);

        System.out.println(mainMenu.toString());


        // using decorator
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(concreteComponent);
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
        ConcreteDecoratorA concreteDecoratorA2 = new ConcreteDecoratorA(concreteDecoratorB);

        System.out.println(concreteDecoratorA2.function());


        // using facade
        DbFacade dbFacade = new DbFacade();
        dbFacade.createTable();
        dbFacade.insertIntoTable();
        for (Address address : dbFacade.getAddresses()) {
            System.out.println(address.toString());
        }


        // using flyweight
        StateCreator stateCreator = new StateCreator();

        stateCreator.createDoSomethingClass("A", 1);
        stateCreator.createDoSomethingClass("A", 2);
        stateCreator.createDoSomethingClass("B", 3);
        stateCreator.createDoSomethingClass("B", 4);
        stateCreator.createDoSomethingClass("C", 5);
        stateCreator.createDoSomethingClass("C", 6);
        stateCreator.createDoSomethingClass("C", 7);
        stateCreator.createDoSomethingClass("A", 8);
        stateCreator.createDoSomethingClass("A", 9);

        stateCreator.process();

        //only creates 3 objects for the 9 doSomethings
        System.out.println(stateCreator.report());


        // using proxy
        TwitterService service1 = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());
        System.out.println(service1.getTimeline("Hello"));
        TwitterService service2 = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());
        service2.postTimeline("Hello", "No wonder there are so many bots...");
        System.out.println(service2.getTimeline("Hello"));

    }
}

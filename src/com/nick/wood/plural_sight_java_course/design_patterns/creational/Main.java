package com.nick.wood.plural_sight_java_course.design_patterns.creational;

import com.nick.wood.plural_sight_java_course.design_patterns.creational.abstract_factory.CardType;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.abstract_factory.CreditCard;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.abstract_factory.CreditCardFactory;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.builder.BuilderPatternExample;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.factory.FactoryTypes;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.factory.Website;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.factory.WebsiteFactory;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.prototype.Book;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.prototype.Movie;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.prototype.Registry;
import com.nick.wood.plural_sight_java_course.design_patterns.creational.singleton.SingletonExample;

public class Main {

    public static void main(String[] args) {

        // using singleton: both below are the same object
        SingletonExample singletonExample1 = SingletonExample.getInstance();
        SingletonExample singletonExample2 = SingletonExample.getInstance();
        System.out.println(singletonExample1);
        System.out.println(singletonExample2);


        // this will throw as the object has already been created and cannot be created again.
        /*for (Constructor<?> constructor : SingletonExample.class.getDeclaredConstructors()) {
            constructor.setAccessible(true);
            try {
                Object o = constructor.newInstance();
            } catch (RuntimeException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }*/

        // Using factory
        BuilderPatternExample.Builder builder = new BuilderPatternExample.Builder();
        BuilderPatternExample builderPatternExample = builder.varOne("hello").varThree("World").build();

        System.out.println(builderPatternExample.getVarOne());
        System.out.println(builderPatternExample.getVarTwo());
        System.out.println(builderPatternExample.getVarThree());
        System.out.println(builderPatternExample.getVarFour());


        // Using prototype
        Registry registry = new Registry();
        Movie movie = registry.createItem("Movie");
        movie.setTitle("Creational patterns in java");

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getPrice());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        Movie movie2 = registry.createItem("Movie");
        movie2.setTitle("Another movie");

        System.out.println(movie2);
        System.out.println(movie2.getRuntime());
        System.out.println(movie2.getPrice());
        System.out.println(movie2.getTitle());
        System.out.println(movie2.getUrl());

        Book book = registry.createItem("Book");
        movie2.setTitle("Whatever");

        System.out.println(book);
        System.out.println(book.getNumberOfPages());
        System.out.println(book.getPrice());
        System.out.println(book.getTitle());
        System.out.println(book.getUrl());


        // using factory
        Website shopWebsite = WebsiteFactory.getWebsite(FactoryTypes.SHOP);
        System.out.println(shopWebsite.getPages());
        Website blogWebsite = WebsiteFactory.getWebsite(FactoryTypes.BLOG);
        System.out.println(blogWebsite.getPages());
        Website wrongCall = WebsiteFactory.getWebsite(FactoryTypes.NOT_IMPLEMENTED);
        System.out.println(wrongCall.getPages());

        // using abstract factory
        CreditCardFactory creditCardFactory = CreditCardFactory.getCreditCardFactory(700);
        CreditCard card = creditCardFactory.getCreditCard(CardType.PLATINUM);
        System.out.println(card.getClass());


        CreditCardFactory creditCardFactory2 = CreditCardFactory.getCreditCardFactory(600);
        CreditCard card2 = creditCardFactory2.getCreditCard(CardType.GOLD);
        System.out.println(card2.getClass());

    }
}

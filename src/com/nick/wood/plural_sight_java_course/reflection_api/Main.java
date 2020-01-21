package com.nick.wood.plural_sight_java_course.reflection_api;

import com.nick.wood.plural_sight_java_course.reflection_api.meta_model.ColumnField;
import com.nick.wood.plural_sight_java_course.reflection_api.meta_model.MetaModel;
import com.nick.wood.plural_sight_java_course.reflection_api.meta_model.PrimaryKeyField;

import java.lang.reflect.Field;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MetaModel metaModel = MetaModel.of(Person.class);

        PrimaryKeyField primaryKeyField = metaModel.getPrimaryKey();
        List<ColumnField> columnFieldList = metaModel.getColumns();

        System.out.println("Primary key name:" + primaryKeyField.getName());
        System.out.println("Primary key type:" + primaryKeyField.getType());

        for (ColumnField columnField : columnFieldList) {

            System.out.println("Column name:" + columnField.getName());
            System.out.println("Column key type:" + columnField.getType());

        }
    }

    private static void reflectionApiStuff() throws Exception {

        Person test = new Person(1, 1, "A");
        Class<?> clss = test.getClass();
        Field field = clss.getDeclaredField("name");
        // this does not make private field public, it suppresses access control on that field
        field.setAccessible(true);
        field.set(test, "B");
        System.out.println(test.getName());

    }

    private static void classStuff() {
         /* Class class
        ----------------------------------------------------------------------------------
         */

        // getting class from object
        String hello = "hello";
        // the get class method is declared on the Object class
        Class aClass = hello.getClass();

        String world = "World";
        Class bClass = hello.getClass();

        // this is always true as there is only one instance of a Class for a given class
        System.out.println(aClass.equals(bClass));

        Integer integer = 1;
        Class cClass = integer.getClass();

        // this is now false as a different Class object would have been created for the class
        // type Integer than class type String
        System.out.println(aClass.equals(cClass));

        // getting class from known class
        Class<String> stringClass = String.class;

        // getting class from name of class
        try {
            Class<?> classFromName = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

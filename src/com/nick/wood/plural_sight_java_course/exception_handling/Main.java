package com.nick.wood.plural_sight_java_course.exception_handling;

import com.nick.wood.plural_sight_java_course.exception_handling.closeable.AutoCloseableResource;
import com.nick.wood.plural_sight_java_course.exception_handling.closeable.CloseableDependantResource;
import com.nick.wood.plural_sight_java_course.exception_handling.closeable.CloseableResource;
import com.nick.wood.plural_sight_java_course.exception_handling.custom_exceptions.ProcessDataException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

    }

    private static void usingCustomException() {
        try {
            customException();
        } catch (ProcessDataException e) {
            System.out.println(e.getCustomData());
        }
    }

    private static void customException() throws ProcessDataException {
        ProcessDataException processDataException = new ProcessDataException(new Exception());
        processDataException.setCustomData(1);
        throw processDataException;

    }

    private static void checkedExceptions() {
        // will not work as IOException is a checked exception
        // this means it is checked at compile time and we will get a compile time exception
        doThrow(new IOException());

        // this will work with generics as the types are erased (type erasure)
        // at compile type so you trick the compiler. this proves the jvm
        // has no knowledge of checked and unchecked types
        doThrowGeneric(new IOException());
    }

    static void doThrow(Exception e) throws RuntimeException {
        throw (RuntimeException) e;
    }

    static <E extends Exception> void doThrowGeneric(Exception e) throws E {
        throw (E) e;
    }

    private static void chainingExceptions() {

        try {
            throw new IOException();
        } catch (IOException e) {
            // re throws runtime exception so program can carry on, and chains the exception, preserving stack trace
            throw new RuntimeException(e);
        }

    }

    private static void exceptionMethodsTest() {
        try {
            throw new Exception("Sample message");
        } catch (Exception e) {
            System.err.println("getMessage(): " + e.getMessage());
            System.err.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.err.println("getCause(): " + e.getCause());
            System.err.println("printStackTrace(): ");
            e.printStackTrace();
            System.err.println("fillInStackTrace(): ");
            e.fillInStackTrace(); // will say error is on this line now
            e.printStackTrace();
        }
    }

    private static void tryWithResourcesTest() {
        try (AutoCloseableResource autoCloseableResource = new AutoCloseableResource();
             CloseableResource closeableResource = new CloseableResource();
             CloseableDependantResource closeableDependantResource = new CloseableDependantResource(closeableResource)) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

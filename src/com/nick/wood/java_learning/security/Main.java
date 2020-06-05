package com.nick.wood.java_learning.security;

import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {



    }

    private static void simpleTest() {
        String version = System.getProperty("java.version");

        try (FileWriter fileWriter = new FileWriter("./src/com/nick/wood/plural_sight_java_course/security/test_without_security_manager.txt")) {
            fileWriter.write("Hello, world!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(version);

        System.setSecurityManager(new SecurityManager());

        // can still see version number using security manager
        System.out.println(version);

        // but cant do io with security manager
        try (FileWriter fileWriter = new FileWriter("./src/com/nick/wood/plural_sight_java_course/security/test_with_security_manager.txt")) {
            fileWriter.write("Hello, world!");
        } catch (IOException | AccessControlException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     *  Use following command line rules to activate securitymanager and set custom policy file
     *
     *  -Djava.security.manager -Djava.security.policy=src/com/nick/wood/plural_sight_java_course/security/java.policy
     */
    private static void editingPolicyFileTest() {
        String home = System.getProperty("user.home");

        try (FileWriter fileWriter = new FileWriter(home + "/java_security_test/test_with_security_manager_and_custom_permissions.txt")) {
            fileWriter.write("Hello, world!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void retrievingCodebase() {

        TestObject testObject = new TestObject();
        ProtectionDomain protectionDomain = testObject.getClass().getProtectionDomain();
        CodeSource codeSource = protectionDomain.getCodeSource();

        System.out.println(codeSource.getLocation().toString());

        Policy policy = Policy.getPolicy();
        PermissionCollection permissions = policy.getPermissions(codeSource);

        System.out.println();

    }

    /**
     *  Run with:
     *
     *  -Djava.security.manager -Djava.security.policy=src/com/nick/wood/plural_sight_java_course/security/policy_file_for_custom_security_manager.policy
     */
    private static void customSecurityManagerExample() {

        System.setSecurityManager(new MySecurityManager());

        MySecurityManager mySecurityManager = (MySecurityManager) System.getSecurityManager();

        mySecurityManager.listPermissions();



    }

    /**
     * Overcomplicating write action to demo waling the state for security reason's
     *
     * run with:
     *
     * -Djava.security.manager -Djava.security.policy=src/com/nick/wood/plural_sight_java_course/security/stack_walk_demo.policy
     */
    private static void walkingTheStackDemo() {

        DataAccess access = new DataAccess("D:/Software/Programming/projects/Java/PluralSightJavaCourse/src/com/nick/wood/plural_sight_java_course/security/walking_the_stack_message.txt");
        DataService service = new DataService(access);

        try {
            service.write("Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * run with:
     *
     * -Djava.security.manager -Djava.security.policy=src/com/nick/wood/plural_sight_java_course/security/policy_file_for_custom_permission.policy
     */
    private static void customPermissionDemo() {

        makeItSo(8);

    }

    private static void makeItSo(int i) {

        SecurityManager securityManager = System.getSecurityManager();

        if (securityManager != null) {
            securityManager.checkPermission(new CustomPermission("Name", String.valueOf(i)));
        }

        System.out.println("Success");

    }
}

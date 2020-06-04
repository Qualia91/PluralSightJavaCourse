package com.nick.wood.java_learning.functional_fsm;

public class Main {

    public static void main(String[] args) {


        Demo demo = new Demo();

        demo.transitionTo(ConnectionState.CONNECTING);
        demo.transitionTo(ConnectionState.CONNECTED);
        demo.transitionTo(ConnectionState.DISCONNECTING);
        demo.transitionTo(ConnectionState.NOT_CONNECTED);

        for (ConnectionStateChange connectionStateChange : demo.getConnectionStateChanges()) {
            System.out.println(connectionStateChange);
        }
    }
}

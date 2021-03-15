package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("this is main method Let me create New Thread");
        Thread runnableThread = new Thread(new RunnableThread());
        runnableThread.start();
        Thread extendsThread = new Thread(new ExtendsThread());
        extendsThread.start();
    }

}

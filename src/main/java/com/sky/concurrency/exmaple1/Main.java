package com.sky.concurrency.exmaple1;

import static com.sky.concurrency.exmaple1.ThreadColor.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE+"Hello from main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("AnotherThread");
        anotherThread.start();

        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN+"Hello from the anonymous thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED+"Hello from anonymous thread");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED+"anotherThread terminated or timed out,so I'm running again");
                }
                catch (InterruptedException e) {
                    System.out.println(ANSI_RED+"I couldn't join thread"+e.getMessage());
                }
            }
        });
        myRunnableThread.start();


        System.out.println(ANSI_PURPLE+"Hello again from main thread");

    }
}

package com.sky.concurrency;

import static com.sky.concurrency.ThreadColor.ANSI_GREEN;
import static com.sky.concurrency.ThreadColor.ANSI_PURPLE;

public class Main {
    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE+"Hello from main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN+"Hello from the anonymous thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        System.out.println(ANSI_PURPLE+"Hello again from main thread");

    }
}

package com.sky.concurrency.exmaple1;

import static com.sky.concurrency.exmaple1.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE+"Hello from "+currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE+ "Another thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE+"There seconds have passed and I'm awake.");
    }
}

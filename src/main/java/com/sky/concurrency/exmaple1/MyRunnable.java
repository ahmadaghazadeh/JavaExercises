package com.sky.concurrency.exmaple1;

import static com.sky.concurrency.exmaple1.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED+"Hello from the runnable");
    }
}

package com.sky.concurrency;

import static com.sky.concurrency.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED+"Hello from the runnable");
    }
}

package com.sky.concurrency;

import static com.sky.concurrency.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE+"AnotherThread is running");
    }
}

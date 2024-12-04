package com.sky.concurrency.exmaple2;

public class Main {
    public static void main(String[] args) {
        CountDown countDown = new CountDown();
        CountDownThread t1=new CountDownThread(countDown);
        t1.setName("Thread 1");
        CountDownThread t2=new CountDownThread(countDown);
        t2.setName("Thread 2");
        CountDownThread t3=new CountDownThread(countDown);
        t3.setName("Thread 3");

        t2.start();
        t3.start();
        t1.start();


    }
}

class CountDown{
    private int i;
    public void doCountDown() {

        String color = switch (Thread.currentThread().getName()) {
            case "Thread 1" -> ThreadColor.ANSI_CYAN;
            case "Thread 2" -> ThreadColor.ANSI_PURPLE;
            case "Thread 3" -> ThreadColor.ANSI_RED;
            default -> ThreadColor.ANSI_GREEN;
        };

        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color+Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CountDownThread extends Thread{
    private CountDown threadCountDown;

    public CountDownThread(CountDown countDown) {
        this.threadCountDown = countDown;
    }
    public void run() {
        threadCountDown.doCountDown();
    }
}

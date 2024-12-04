package com.sky.concurrency.producerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final String EOF="EOF";
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        MyProducer myProducer=new MyProducer(buffer,ThreadColor.ANSI_BLUE);
        MyConsumer myConsumer1=new MyConsumer(buffer,ThreadColor.ANSI_RED);
        MyConsumer myConsumer2=new MyConsumer(buffer,ThreadColor.ANSI_GREEN);

        new Thread(myProducer).start();
        new Thread(myConsumer1).start();
        new Thread(myConsumer2).start();

    }
}

class MyProducer implements Runnable {

    private final List<String> buffer;
    private final String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] num = {"1","2","3","4","5" };
        for (String num1 : num) {
            try {
                System.out.println(color+ "Adding " + num1);
                synchronized (buffer) {
                    buffer.add(num1);
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
               System.out.println(color + "Thread interrupted");
            }
        }
        System.out.println(color + "Thread exiting");
        synchronized (buffer) {
            buffer.add("EOF");
        }
    }
}

class MyConsumer implements Runnable {

    private final List<String> buffer;
    private final String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals("EOF")) {
                    System.out.println(color + "Thread exiting");
                    break;
                }else {
                    System.out.println(color + "remove " + buffer.remove(0));
                }
            }
        }
    }
}

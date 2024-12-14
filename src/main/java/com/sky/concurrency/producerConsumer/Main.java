package com.sky.concurrency.producerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF="EOF";
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executorService= Executors.newFixedThreadPool(3);

        MyProducer myProducer=new MyProducer(buffer,ThreadColor.ANSI_BLUE);
        MyConsumer myConsumer1=new MyConsumer(buffer,ThreadColor.ANSI_RED);
        MyConsumer myConsumer2=new MyConsumer(buffer,ThreadColor.ANSI_GREEN);

        executorService.execute(myConsumer1);
        executorService.execute(myConsumer2);
        executorService.execute(myProducer);




        Future<String> future=executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_PURPLE+"I'm being printed for the Callable");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        }catch (InterruptedException | ExecutionException e) {

        }
        executorService.shutdown();
        //new Thread(myConsumer1).start();
        //new Thread(myConsumer2).start();
        //new Thread(myProducer).start();


    }
}

class MyProducer implements Runnable {

    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
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
                buffer.put(num1);
            } catch (InterruptedException e) {
               System.out.println(color + "Thread interrupted");
            }
        }
        System.out.println(color + "Adding EOF exiting");

            try {
                buffer.put("EOF");
            }catch (InterruptedException e) {
                System.out.println(color + "Thread interrupted");
            }
    }
}

class MyConsumer implements Runnable {

    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {

                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals("EOF")) {
                        System.out.println(color + "Thread exiting");
                        break;
                    }else {
                        System.out.println(color + "remove " + buffer.take());
                    }

            } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
        }
    }
}

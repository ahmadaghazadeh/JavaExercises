package com.sky.concurrency.messages;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Writer(message)).start();
        new Thread(new Reader( message)).start();
    }
}

class Message{
    private String message;
    private boolean empty=true;

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            }
            catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }
    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            }
            catch (InterruptedException e) {

            }

        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable {
    private Message message;
    public Writer(Message message) {
        this.message = message;
    }
    public void run() {


        var messages= IntStream.rangeClosed(1,1000).mapToObj((i)-> "sentence "+i).toList();
        Random random = new Random();

        for (String s : messages) {
            message.write(s);

        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;
    public Reader(Message message) {
        this.message = message;
    }
    public void run() {
        Random random = new Random();
        for (String latestMessage=message.read(); !latestMessage.equals("Finished");
        latestMessage = message.read()) {
            System.out.println(latestMessage);

        }
    }
}

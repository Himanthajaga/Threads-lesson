package org.example;

class MyThread extends Thread {
    public void run() {
        System.out.println("Child thread started");
    }
}
public class ExtendThreadClass {
    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        mythread.start();
        System.out.println("Main thread started");
    }
}
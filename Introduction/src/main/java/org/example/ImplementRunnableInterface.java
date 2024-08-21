package org.example;
class MyThreadR implements Runnable {

    public void run() {
        System.out.println("Child thread started");
    }
}
    public class ImplementRunnableInterface {
        public static void main(String[] args) {
            MyThreadR mythread = new MyThreadR();
            Thread t = new Thread(mythread);
            t.start();
            System.out.println("Main thread started");
        }
    }

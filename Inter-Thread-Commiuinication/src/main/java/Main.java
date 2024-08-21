class Q{
    int num;
    boolean value = false;
    public synchronized void output(int num){
       while(value){
           try {
               wait();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
        System.out.println("PUT : "+num);
       this.num=num;
         value = true;
            notify();
    }
    public synchronized void get(){
        while (!value){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("GET : "+num);
        value = false;
        notify();
    }
}
class Producer implements Runnable{
    Q q;
    Producer(Q q){
        this.q = q;
        Thread t1 = new Thread(this,"Producer");
        t1.start();
    }
    @Override
    public void run() {
        int i = 0;
        while(true){
            q.output(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Consumer implements Runnable{
    Q q;
    Consumer(Q q){
        this.q = q;
        Thread t2 = new Thread(this,"Consumer");
        t2.start();
    }
    @Override
    public void run() {
        while(true){
            q.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}

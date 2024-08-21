public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("ewwwwwwww");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("mmmmmm");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        System.out.println(t1.isAlive());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        System.out.println(t2.isAlive());
        try {
            t1.join();
            System.out.println(t1.isAlive());
            t2.join();
            System.out.println(t2.isAlive());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye bye!");
    }
}

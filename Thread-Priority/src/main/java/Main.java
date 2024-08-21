
public class Main {
    public static void main(String[] args) {
       Thread t1 = new Thread(()->{
              for (int i = 0; i < 5; i++) {
                System.out.println("thread1");
                try {
                     Thread.sleep(1000);
                } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                }
              }
         });
          Thread t2 = new Thread(()->{
                for (int i = 0; i < 5; i++) {
                 System.out.println("thread2");
                 try {
                      Thread.sleep(500);
                 } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                 }
                }
          });
          t1.setPriority(Thread.MIN_PRIORITY);
            t2.setPriority(Thread.NORM_PRIORITY);
            t1.setPriority(Thread.MAX_PRIORITY);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t1.getName());
        System.out.println(t2.getName());
          t1.start();
          try {
                Thread.sleep(10);
          } catch (InterruptedException e) {
                throw new RuntimeException(e);
          }
          t2.start();
          try {
                t1.join();
          } catch (InterruptedException e) {
                throw new RuntimeException(e);
          }
          try {
                t2.join();
          } catch (InterruptedException e) {
                throw new RuntimeException(e);
       }
    }
}

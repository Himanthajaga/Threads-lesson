
    class One extends Thread {
        public void run() {
          for (int i = 0; i < 5; i++) {
            System.out.println("ewwwwwwww");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        }
    }
    class Two extends Thread {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("mmmmmm");
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
            One one = new One();
            Two two = new Two();
            one.start();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            two.start();
        }
    }

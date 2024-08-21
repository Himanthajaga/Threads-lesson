public class MyRunnable implements Runnable{
    public String name;
    public MyRunnable(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Thread "+name+" is start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+name+" is end");
    }
}

package 线程;

public class Thread_join_sleep {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(10000);
        System.out.println("main");

        Thread.currentThread().join();
        System.out.println("22222222222222222222");


    }
}

class Runnable1 implements Runnable{

    private Thread thread;

    public Runnable1(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            thread.join(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Runnable1");
    }
}

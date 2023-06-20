package 线程;

public class volatile_1 {
    private volatile static int signal = 0;

    static class ThreadA implements Runnable {
        @Override
        public void run(){
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println("ThreadA: " + signal);
//                    synchronized (this) {
                        signal++;
//                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 1){
                    System.out.println("ThreadB: " + signal);
//                    synchronized (this){
                        signal++;
//                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // volatile 变量需要进⾏原⼦操作。 signal++ 并不是⼀个原⼦操
        // 作，所以我们需要使⽤ synchronized 给它“上锁”
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }

}

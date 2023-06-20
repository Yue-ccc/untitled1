package JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueue_ {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<String>(3);

        for (int i = 0; i < 4; i++) {
            final int n=i;
            new Thread(()->{
                try {
                    blockingQueue.put(Thread.currentThread().getName()+"----"+n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        TimeUnit.MILLISECONDS.sleep(10);
        for (int i = 0; i < 4; i++) {
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue);
        }

    }



}

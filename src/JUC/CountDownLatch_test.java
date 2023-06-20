package JUC;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch_test {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"->>");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("cd执行完啦");



    }

}

package JUC;

import java.util.concurrent.*;

public class ThreadPool_test {
    public static void main(String[] args) {
//        test1();
        test2();




    }
    static void test1(){
        //1、普通Executes工具类三大方法获取线程池的方法，不推荐使用
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                final int count=i;
                cachedThreadPool.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"---->"+count);
                },i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            singleThreadExecutor.shutdown();
            fixedThreadPool.shutdown();
            cachedThreadPool.shutdown();
        }
    }
    static void  test2(){
        //2、上面三大方法的底层都是用ThreadPoolExecutor类，我们也可以使用ThreadPoolExecutor来自定义参数
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, Runtime.getRuntime().availableProcessors(),
                60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()//默认策略，当要执行的线程数大于最大线程数（maximumPoolSize最大线程数+workQueue的容量），丢弃剩余的线程并报错
//                new ThreadPoolExecutor.CallerRunsPolicy()//当要执行的线程数大于最大线程数时，任务回退给主线程执行
//                new ThreadPoolExecutor.DiscardPolicy()//当要执行的线程数大于最大线程数，丢弃剩余的线程但不会报错
                new ThreadPoolExecutor.DiscardOldestPolicy()//当要执行的线程数大于最大线程数，尝试将任务交给给最早执行的线程
        );

        try {
            for (int i = 0; i < 11; i++) {
                final int count=i;
//                System.out.println(count);
                threadPoolExecutor.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"---->"+count);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}

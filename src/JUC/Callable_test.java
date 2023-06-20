package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callable_test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask,"A").start();

        String s = futureTask.get();
        System.out.println(s);

    }
    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {

            Thread.sleep(5000);
            System.out.println("call is running");

            return "fuck you";
        }
    }
}

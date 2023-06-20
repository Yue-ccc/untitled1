package JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentList {
    public static void main(String[] args) throws InterruptedException {

//        ArrayList<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(String.valueOf(UUID.randomUUID()));
                System.out.println(Thread.currentThread().getName()+list);
            },String.valueOf(i)).start();
        }
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+list);


    }
}

package JUC;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_Condition {
    public void main(String[] args) {
        ticket ticket = new ticket();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ticket.incr();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ticket.decr();
            }
        },"B").start();


    }
    class ticket{
        private int num=0;
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        public void incr(){
            lock.lock();
            try {
                while (num==1){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName()+"->incr->>>"+num);
                num++;
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void decr(){
            lock.lock();
            try {
                while (num==0){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName()+"->decr->>>"+num);
                num--;
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }

}


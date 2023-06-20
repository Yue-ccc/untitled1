package 线程;

public class 消息传递的线程通信 {
//    static int[] arr=new int[]{0,1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        myThread1.setName("线程1");
        MyThread myThread2 = new MyThread();
        myThread2.setName("线程2");

        myThread1.start();
        myThread2.start();
//
//        MyRunnable myRunnable = new MyRunnable();
//        new Thread(myRunnable,"线程1").start();
//        new Thread(myRunnable,"线程2").start();


    }

}
class MyThread extends Thread{
    static int num=100;
    @Override
    public void run() {
        synchronized(MyThread.class){
            while (num>0){
                System.out.println("线程名为"+Thread.currentThread()+"----->num:"+num);
                num--;
                MyThread.class.notify();//等同于notify();
                try {
                    MyThread.class.wait();//等同于wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class MyRunnable implements Runnable {
    static int num=100;
    @Override
    public synchronized void run() {
        while (num>0){
            System.out.println("线程名为"+Thread.currentThread()+"----->num:"+num);
            num--;
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
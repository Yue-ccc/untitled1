package 线程;

public class 共享内存的线程通信volatile {
    static volatile boolean flag=false;
    static int num=10;
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("静态方法.t1");
        MyThread2 myThread2 = new MyThread2();
        myThread2.setName("t2");

        myThread1.start();
        myThread2.start();

    }

    static class MyThread1 extends Thread{
        @Override
        public void run() {
//            synchronized (线程.MyThread.class){
                while (num>0){
                    if (flag==true && num>0){
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("线程名为"+Thread.currentThread()+"----->num:"+num);
                        num--;
                        flag=!flag;
                    }
//                }
            }
        }
    }
    static class MyThread2 extends Thread {
        @Override
        public void run() {
//            synchronized (线程.MyThread.class){
            while (num > 0) {
                if (flag == false && num > 0) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("线程名为" + Thread.currentThread() + "----->num:" + num);
                    num--;
                    flag = !flag;
                }
//                }
            }
        }
    }
}

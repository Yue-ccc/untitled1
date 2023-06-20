package 线程;

public class 共享内存的线程通信 {
    static boolean flag=false;
    static int num=10;
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.setName("t1");
        MyThread myThread2 = new MyThread();
        myThread2.setName("t2");

        myThread1.start();
        myThread2.start();

    }

    static class MyThread extends Thread{
        @Override
        public void run() {
//            synchronized (线程.MyThread.class){
                while (num>0){
                    if (flag==true && Thread.currentThread().getName().equals("t1") && num>0){
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("线程名为"+Thread.currentThread()+"----->num:"+num);
                        num--;
                        flag=!flag;
                    }
                    if (flag==false && Thread.currentThread().getName().equals("t2") && num>0){
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
}

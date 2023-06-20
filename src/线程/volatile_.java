package 线程;

public class volatile_ {
    static int num=20;
    public static void main(String[] args) {
        r r1 = new r();
        new Thread(r1,"t1").start();
        new Thread(r1,"t2").start();
    }
    static class r implements Runnable{
        @Override
        public void run() {
            while (num>0){
                synchronized (r.class){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"->>>"+num);
                    num--;
                }
            }
        }
    }
}

package alibaba;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author zhuliyang
 * @date 2019-12-01
 * @time 21:58
 **/
public class ThreadPrinter2 {
    static int i = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 30) {
                    if (i % 3 == 0) {
                        System.out.println("A");
                    }
                    i++;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 30) {
                    if (i % 3 == 1) {
                        System.out.println("B");
                    }
                    i++;
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 30) {
                    if (i % 3 == 2) {
                        System.out.println("C");
                    }
                    i++;
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
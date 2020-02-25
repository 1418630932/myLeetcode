package alibaba;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author zhuliyang
 * @date 2019-12-01
 * @time 21:58
 **/
public class ThreadPrinter implements Runnable {
    int i = 0;
    public static void main(String[] args) {
        ThreadPrinter thread = new ThreadPrinter();
        Thread t1 = new Thread(thread,"A");
        Thread t2 = new Thread(thread,"B");
        Thread t3 = new Thread(thread,"C");
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
            while (true){
                if (i%3==0){
                    System.out.print("A");
                    i++;
                }else if (i%3==1){
                    System.out.print("B");
                    i++;
                }else {
                    System.out.print("C");
                    i++;
                }
            }
    }
}

package gui;

import java.util.concurrent.*;

/**
 * @author jzx
 * @date 2020/1/8
 */
public class PoolTest implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000*60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> quene = new LinkedBlockingQueue<Runnable>(2);
        quene.add(new PoolTest());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, quene);
        for (int i = 0; i < 5; i++) {
            try {
                threadPoolExecutor.submit(new PoolTest());
            }catch (RejectedExecutionException e){
                System.out.println("quene" + quene.size());
            }
        }



    }
}

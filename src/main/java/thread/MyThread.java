package thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author jzx
 * @date 2020/4/3
 */
public class MyThread {
    static   ExecutorService pool =null;
    static volatile int i = 1;

    static {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("lottery-pool-%d").build();
         pool = new ThreadPoolExecutor(1, 1,
                1L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(Integer.MAX_VALUE/2), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    public static void main(String[] args) {
        for (int j = 0; j <100; j++) {
            pool.execute(new Thread(() -> {
                int add = IntService.add(i);
                System.out.println("add = " + add);
                System.out.println(Thread.currentThread().getName());
            }));
        }

    }
}

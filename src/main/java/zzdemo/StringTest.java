package zzdemo;

import util.DateUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jzx
 * @date 2020/6/7
 * @desc
 */
public class StringTest {

    private  volatile  DateUtils m;
    private  volatile  int  a;
    private  static  volatile  int  sdsadsa;

    Object lock  = new Object();
    public static void main(String[] args) {
        new Callable<Boolean>(){

            @Override
            public Boolean call() {

                try {
                    test1();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                return  true;
            }
        }.call();



    }









   public static void test1() throws Throwable{

        try {
            int i = 1/0;
        }catch (Exception e){
            System.out.println("e = " + 1);
            throw  new RuntimeException(e);
        }
   }
}

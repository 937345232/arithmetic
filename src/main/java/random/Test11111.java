package random;

/**
 * @author jzx
 * @email:
 * @Date: 2019-07-16 17:43
 */
public class Test11111 implements Runnable {
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("name = " + name);
    }


    public static void main(String[] args) {
//        Test11111 test11111 = new Test11111();
//        new Thread(test11111).start();
//        String name = Thread.currentThread().getName();
//        System.out.println("name = " + name);
        Double a = 1.1;
        System.out.println("a = " + a.toString());
    }

    public Test11111() {
        super();
    }
}

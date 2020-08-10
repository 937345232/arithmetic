package single;

/**
 * @author jzx
 * @date 2020/5/17
 * @desc
 */
public class SingleDemo1 {
    private SingleDemo1() {
    }


    private static SingleDemo1 singleDemo = null;

    public static  synchronized SingleDemo1 newInstance() {
        synchronized (SingleDemo1.class){
            if(singleDemo==null){
                singleDemo = new SingleDemo1();
                return singleDemo;
            }
            return singleDemo;

        }

    }

}

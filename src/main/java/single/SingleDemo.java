package single;

import java.math.BigDecimal;

/**
 * @author jzx
 * @date 2020/5/17
 * @desc
 */

public class SingleDemo {
    public static void main(String[] args) {
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal bigDecimal = new BigDecimal(0.0000);
        System.out.println(zero.compareTo(bigDecimal));
    }

}

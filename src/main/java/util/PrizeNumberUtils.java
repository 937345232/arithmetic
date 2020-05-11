package util;

import java.math.BigDecimal;

/**
 * @author jzx
 * @date 2020/3/23
 */
public class PrizeNumberUtils {


    /**
     * 保留两位小数
     *
     * @return
     */
    public static double formatMoney(double money) {
        if (money >= 0.0) {
            return new BigDecimal(money).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        } else {
            throw new RuntimeException("格式化金额异常,金额必须大于0");
        }
    }

    public static double subtract(double money,double money2) {
        BigDecimal subtract = new BigDecimal(money).subtract(new BigDecimal(money2));
        return subtract.setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
    }
}

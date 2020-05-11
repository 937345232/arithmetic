package util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author jzx
 * @date 2020/1/15
 */
public class DateUtils {

//    public static void main(String[] args) {
////        LocalDate now = LocalDate.now();
////        System.out.println("now = " + now);
//        LocalDate date1 = LocalDate.now();
//
//        LocalDate date2 = LocalDate.of(2020,1,15);
//        LocalDate parse = LocalDate.parse("2020-01-15 20:12:12");
//        System.out.println("parse = " + parse);
//
////        if(date1.equals(date2)){
////            System.out.println("时间相等");
////        }else{
////            System.out.println("时间不等");
////        }
//    }


    public static void main(String[] args) {
        while (true){
            List<Double> amount = amount(100.0, 20.0, 10.0, 6);
            System.out.println("amount = " + amount);
            int result = 0;
            for (Double aDouble : amount) {
                result += new Double(aDouble*100).intValue();
            }

            System.out.println("result = " + result);
            if(result>10000){
                break;
            }
        }

    }

    public static List<Double> amount(Double totalAmount,Double maxAmount, Double min, int num){
//        if (maxAmount == null || maxAmount <= 0 || num <= 0) {
//            return null;
//        }
//        if (min == null || min == 0) {
//            min = 0.01;
//        }
//        if (num * min > totalAmount) {
//            return null;
//        }
        List<Double> redEnvelopes = new ArrayList();
        double sum =0.0;
        for (int i = 0; i < num; i++) {
            double money=0.0;
            if(i==num-1){
                money = PrizeNumberUtils.subtract(totalAmount,sum);
                if(money>maxAmount){
                    //金额
                    money  = PrizeNumberUtils.formatMoney(Math.random()*(maxAmount-min) + min);
                }
            }else {
                money  = PrizeNumberUtils.formatMoney(Math.random()*(maxAmount-min) + min);
            }
            sum+=money;
            redEnvelopes.add(money);
        }
        return redEnvelopes;
    }
}

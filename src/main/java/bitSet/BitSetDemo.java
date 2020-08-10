package bitSet;

import java.util.BitSet;
import java.util.Random;

/**
 * @author jzx
 * @date 2019/12/5
 */
public class BitSetDemo {

    public static void main(String args[]) {
        bitsetTest();
    }
    public static void bitsetTest() {
        BitSet set = new BitSet();
        set.set(3);
        set.set(4);
        set.set(30);
       System. out.println(set.cardinality()); // 统计 Bitset 中 为真的个数
       System. out.println(set.size());
       System. out.println(set.length());
       System. out.println(set.toString()); // 返回值为true 的位置号
       System. out.println(set.nextClearBit(3));// 从指定位置第一个为真的序号
        boolean b = set.get(3);
        System.out.println("b = " + b);
    }


}

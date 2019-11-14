package leetcode;

import java.util.HashMap;


/**
 * @author jzx
 * @Date: 2019-11-13 16:11
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 输入: "xxabcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为3。
 */
public class Day01_3 {


    public static void main(String[] args) { //2 4
        System.out.println("i = " + repeatChar("xxabcabcbb"));
    }

    public static int repeatChar(String source) {
        int max = 0;
        int length = source.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        for (int right = 0; right < length; right++) {
            if (map.containsKey(source.charAt(left))) {
                left = Math.max(map.get(source.charAt(left)), right);
            }
            map.put(source.charAt(left), right);
            max =Math.max(max,)
        }


    }
}

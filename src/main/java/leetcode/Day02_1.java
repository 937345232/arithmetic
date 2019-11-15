package leetcode;

import java.util.HashMap;


/**
 * @author jzx
 * @Date: 2019-11-13 16:11
 * <p>
 * 输入: "abcabcbb"->3
 * 输入: "vxabcx"-> 4
 * 输出: 3
 */
public class Day02_1 {


    public static void main(String[] args) { //2 4
        System.out.println("i = " + repeatChar("dvaadf"));
    }

    public static int repeatChar(String source) {
        int ans = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int length = source.length();
        for (int right = 0; right < length; right++) {
            if (map.containsKey(source.charAt(right))) {
                //map.get(source.charAt(right))
                // 当遇到重新字符d 需要重当前位置开始数左侧第一个d位置 重新计算left下标(d+1)
                left = Math.max(map.get(source.charAt(right)), left);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(source.charAt(right), right + 1);

        }
        return ans;
    }
}

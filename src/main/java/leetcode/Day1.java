package leetcode;

import java.util.HashMap;

/**
 * @author jzx
 * @Date: 2019-11-13 14:12
 * @desc
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2,  11, 15,7], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * step  begin
 * 1:   9 -2 = 7    |  map -> 7, 0
 * 2:   9-11 =-2    |  map -> -2, 1
 * 3:   9-15 =6    |  map -> 6, 2
 * 3:  7 ->map.containsKey=true retrun map(7, 0)
 */
public class Day1 {

    public static void main(String[] args) {
        int[] test = {2,11, 15, 7};
        int[] num = getNum(test, 13);
        for (int i : num) {
            System.out.println("i = " + i);
        }
    }

    public static int[] getNum(int[] data, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            int result = target - data[1];
            if ((map.containsKey(result))) {
                return new int[]{data[map.get(result)], data[i]};
            }
            map.put(result, i);
        }
        return null;

    }
}

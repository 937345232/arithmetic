/**
 * @author jzx
 * @date 2020/5/17
 * @desc
 */
public class MyString {

    public static boolean repeatedSubstringPattern(String s) {

        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);

    }


    public static void main(String[] args) {
        String data = "a";
        String result = data +data;
        String substring = result.substring(1, result.length() - 1);
        System.out.println("substring = " + substring);
        System.out.println(repeatedSubstringPattern(data));
    }

}









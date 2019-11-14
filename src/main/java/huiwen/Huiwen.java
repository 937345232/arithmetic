package huiwen;

/**
 * @author jzx
 * @email:
 * @Date: 2019-11-13 10:36
 */
public class Huiwen {
//     [2, 7, 11, 15], target = 9
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(isPalindrome("aaaoioaaa"));

    }

}

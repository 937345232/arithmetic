package random;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author jzx
 * @email:
 * @Date: 2019-07-16 17:43
 */
public class Test11111 implements Runnable {
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("name = " + name);
    }


    public static void main(String[] args) {
        String username = "18621612307";

        System.out.println("username = " +  fix("18621612307"));
        System.out.println("username = " +  fix("186216123aa07"));
        System.out.println("username = " +  fix("aa"));
        System.out.println("username = " +  fix("1111111111111111"));
    }

    private static String fix(String username) {
        String fixName = "";
        if (username.length() > 7) {
            String prefix = username.substring(0, 3);
            String last = username.substring(username.length() - 4, username.length());
            fixName = prefix + "****" + last;
            return fixName;
        } else if (username.length() > 2) {
            String prefix = username.substring(0, 1);
            String last = username.substring(username.length() - 1, username.length());
            fixName = prefix + "****" + last;
        }
        if (username.length() <= 2) {
            fixName = username.substring(0, 1) + "****";
        }
        return fixName;

    }

}

package leetcode;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jzx
 * @email:
 * @Date: 2019-11-13 14:52
 * <p>
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://blog.csdn.net/jzx937345232/ 时，
 * 它将返回一个简化的URL http://csdn.as/i8du3.
 * <p>
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 */
public class Day01_2 {

    static String sign = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static ConcurrentHashMap<String, String> url = new ConcurrentHashMap();

    public static void main(String[] args) {
        String encode = encode("https://blog.csdn.net/jzx937345232");
        System.out.println("encode = " + encode);
        String decode = decode(encode);
        System.out.println("decode = " + decode);
    }


    public static String encode(String longUrl) {
        String[] split = longUrl.split("//");
        StringBuilder decodeUrl = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = new Random().nextInt(sign.length() - 1);
            decodeUrl.append(sign.charAt(index));
            if (i == 3) {
                decodeUrl.append("/");
            }
            if (i == 5) {
                decodeUrl.append("/");
            }
        }
        url.put(decodeUrl.toString(), longUrl);
        return split[0]+"//"+decodeUrl.toString();

    }

    public static String decode(String shortUrl) {
        String[] split = shortUrl.split("//");
        String decodeUrl = split[1];
        if (url.containsKey(decodeUrl)) {
            return  url.get(decodeUrl);
        }
        return "www.baidu.com";
    }

}

package stream;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jzx
 * @email: jiazhaoxin@ule.com
 * @Date: 2019-07-22 10:54
 */
public class MainTest {
    public static void main(String[] args) {
        ConcurrentHashMap m = new ConcurrentHashMap();
        m.put(100, "Hello");
        m.put(101, "Geeks");
        m.put(102, "Geeks");

        // Here we cant add Hello because 101 key
        // is already present in ConcurrentHashMap1 object
        m.putIfAbsent(101, "Hello");
        System.out.println(m);
        // We can remove entry because 101 key
        // is associated with For value
        m.remove(101, "Geeks");
        System.out.println(m);
        // Now we can add Hello
        m.putIfAbsent(103, "Hello");
        System.out.println(m);
        // We cant replace Hello with For
        m.replace(101, "Hello", "For");
        System.out.println(m);
    }
}

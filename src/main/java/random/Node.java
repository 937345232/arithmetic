package random;

/**
 * @author jzx
 * @email: jiazhaoxin@ule.com
 * @Date: 2019-04-28 18:02
 */
public class Node implements Comparable {
    //权重百分比
    int percent;
//   连接url;
    String value;

    public Node(int percent, String value) {
        this.percent = percent;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "percent=" + percent +
                ", value='" + value + '\'' +
                '}';
    }


    public int compareTo(Object obj) {
        Node node = (Node) obj;
        if (this.percent > node.percent) {
            return 1;
        } else {
            return -1;
        }
    }
}

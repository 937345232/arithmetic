package random;

import java.util.*;

/**
 * @author jzx
 * @email: jiazhaoxin@ule.com
 * @Date: 2019-04-28 17:46
 */
public class Test111 {
    /**
     * 这里权重配置的百分比需要搞明白一点:  5%  10%各是什么含义   5% : 比如说  100内数字  1-5内出现的概率就是5%  所以当数字出现在1-5 就是5%
     * 10% : 的含义可以理解为5-15   20%.... 这样累加满100   所以 配置的权重百分比=100内随机数字出现数字所在范围的概率
     * 举例子   3 , 11, ,21 ,65 这些随机数字
     * 3 : 当出现random.nextInt = 6的时候 这个时候 应该出现在5%
     * 11 :当出现random.nextInt = 6的时候 这个时候 应该出现在10%
     * 21  :当出现random.nextInt = 6的时候 这个时候 应该出现在20%
     * ....
     * 找这个规律  随机数与 由最小开始累加  第一次 发现小于那就是当前的概率范围 返回就可以了
     */


    public static int url = 5;     //1-5           sum  = 5
    public static int url2 = 10;    // 5-15        sum  = 15
    public static int url3 = 20;    //15-35       sum  = 35
    public static int url4 = 25;    //35-60       sum  = 60
    public static int url5 = 40;    // 60 - 100   sum  = 100


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Node> data = new ArrayList();
        initData(data);
//        data.add(new Node(url5, "6666666666666666666666"));
        //统计100中各个百分比出现次数
        HashMap<Node, Integer> result = new HashMap();
        for (long i = 1; i <= 1000000000L; i++) {
            try {
                Node resultNode = getNode(data);
                if (result.containsKey(resultNode)) {
                    result.put(resultNode, result.get(resultNode) + 1);
                } else {
                    result.put(resultNode, 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<Node, Integer> nodeIntegerEntry : result.entrySet()) {
            System.out.println("概率->" + nodeIntegerEntry.getKey().value + "出现的次数 :" + nodeIntegerEntry.getValue());
        }

    }

    private static void initData(ArrayList<Node> data) {
        data.add(new Node(url, "this is the first url"));
        data.add(new Node(url2, "this is the sec url"));
        data.add(new Node(url3, "this is the thr url"));
        data.add(new Node(url4, "this is the four url"));
        data.add(new Node(url5, "this is the five url"));
    }


    private static Node getNode(List<Node> node) throws Exception {
        int randomNum = new Random().nextInt(100);
        //小到大排序
        Collections.sort(node);
        int total = 0;
        for (Node node1 : node) {
            total += node1.percent;
        }
        if (total != 100) {
            throw new Exception("percent error");
        }
        //若果所有概率相等//
        boolean flagAverPercent = false;
        for (Node node1 : node) {
            if (node1.percent == node.get(0).percent) {
                flagAverPercent = true;
            }
        }
        if (flagAverPercent) {
            //获取小于当前集合size 的随机数
//            随机return
            return node.get(new Random().nextInt(node.size()));
        }
        int index = 0;
        //统计概率累计
        int sum = 0;
        for (int currentIndex = 0; currentIndex < node.size(); currentIndex++) {
            //sum : 用作统计 当前集合中 从小开始做加法 如果发现随机数字小于当前sum 那么 随机数 应该就是当前下标的node范围内
            sum += node.get(currentIndex).percent;
            if (randomNum < sum) {
                index = currentIndex;
                break;
            }
        }

        return node.get(index);
    }


}

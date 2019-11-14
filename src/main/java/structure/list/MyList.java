package structure.list;

/**
 * @author jzx
 * @date 2019/11/8
 */
public class MyList {
    /**
     * 头结点插入
     *
     * @param head
     * @param newHead
     */
    public static void addHead(ListNode head, ListNode newHead) {
//        ListNode old = head;
//        head = newHead;
//        head.next = old;
        newHead.next = head;
    }


    /**
     * 尾节点插入
     *
     * @param tailNode
     * @param newTail
     */
    public static void addTail(ListNode tailNode, ListNode newTail) {
        //ListNode old = tailNode;
        tailNode.next = newTail;
        newTail.next = null;

    }


    /**
     * 遍历
     *
     * @param node
     */
    public static void traverse(ListNode node) {
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
        }
    }


    public static void findNode(ListNode head, ListNode node) {
        while (head != null) {
            if (head.value == node.value){
                System.out.println("找到node = " + head.value);
            }
           head = head.next;
        }
    }

}

package leetcode;

/**
 * @author jzx
 * @date 2019/11/15
 */
//给定一个二叉树，找出其最大深度。
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//说明: 叶子节点是指没有子节点的节点。
//示例：
//给定二叉树 [3,9,20,null,null,15,7]
public class Day02_2 {


    public static void main(String[] args) {
        Integer[] arr = {3, 23, 11, null, null, 21, 99};
        TreeNode treeNode = arrayToNode(arr, 0);
        System.out.println("treeNode = " + treeNode);
    }


    public static TreeNode arrayToNode(Integer[] arr, int index) {
        TreeNode treeNode = new TreeNode();
        if (index <=arr.length - 1) {
            treeNode.value = arr[index];
            treeNode.leftChild = arrayToNode(arr, index * 2 + 1);
            treeNode.rightNode = arrayToNode(arr, index * 2 + 2);
        }
        return treeNode;
    }


    public static class TreeNode {
        public Integer value;
        public TreeNode leftChild;
        public TreeNode rightNode;
    }

}


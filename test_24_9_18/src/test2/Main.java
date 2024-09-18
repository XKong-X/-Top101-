package test2;

/**
 * Created with IntelliJ IDEA.
 * Description: BM33 二叉树的镜像
 * Author: 行空XKong
 * Date: 2024-09-18
 * Time: 21:29
 * Version:
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode Mirror(TreeNode pRoot) {
        // // 方法一（从根节点开始新创建一个二叉树）
        // if (pRoot == null) {
        //     return pRoot;
        // }
        // TreeNode head = new TreeNode(pRoot.val);
        // head.right = Mirror(pRoot.left);
        // head.left = Mirror(pRoot.right);
        // return head;

        // 方法二（从叶子节点开始交换左右节点）
        if (pRoot == null) {
            return pRoot;
        }
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }
}

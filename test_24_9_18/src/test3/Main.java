package test3;

/**
 * Created with IntelliJ IDEA.
 * Description: BM34 判断是不是二叉搜索树
 * Author: 行空XKong
 * Date: 2024-09-18
 * Time: 22:54
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
    private int prev = Integer.MIN_VALUE;

    // 中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        // 先进左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val < prev) {
            return false;
        }
        prev = root.val;
        return isValidBST(root.right);
    }
}
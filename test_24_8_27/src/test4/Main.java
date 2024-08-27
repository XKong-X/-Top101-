package test4;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: BM25 二叉树的后序遍历
 * Author: 行空XKong
 * Date: 2024-08-27
 * Time: 23:02
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
    private List<Integer> nums = new ArrayList<>();

    public int[] postorderTraversal(TreeNode root) {
        // // 方法一（递归）
        // if (root == null) {
        //     return new int[0];
        // }
        // postorderTraversal(root.left);
        // postorderTraversal(root.right);
        // nums.add(root.val);
        // int[] ret = new int[nums.size()];
        // for (int i = 0; i < nums.size(); ++i) {
        //     ret[i] = nums.get(i);
        // }
        // return ret;

        // 方法二（栈）
        if (root == null) {
            return new int[0];
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            // 走到最左边
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (node.right == null || node.right == prev) {// 走到叶节点或已访问过
                nums.add(node.val);
                prev = node;// 记录
            } else {
                stack.push(node);
                root = node.right;// 继续往右访问
            }
        }
        int[] ret = new int[nums.size()];
        for (int i = 0; i < nums.size(); ++i) {
            ret[i] = nums.get(i);
        }
        return ret;
    }
}

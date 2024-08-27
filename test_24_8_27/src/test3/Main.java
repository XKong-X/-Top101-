package test3;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: BM24 二叉树的中序遍历
 * Author: 行空XKong
 * Date: 2024-08-27
 * Time: 22:32
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

    public int[] inorderTraversal(TreeNode root) {
        // // 方法一（递归）
        // if (root == null) {
        //     return new int[0];
        // }
        // inorderTraversal(root.left);
        // nums.add(root.val);
        // inorderTraversal(root.right);
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
        while (root != null || !stack.isEmpty()) {
            // 走到最左边
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            nums.add(node.val);
            root = node.right;
        }
        int[] ret = new int[nums.size()];
        for (int i = 0; i < nums.size(); ++i) {
            ret[i] = nums.get(i);
        }
        return ret;
    }
}

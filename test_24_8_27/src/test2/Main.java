package test2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: BM23 二叉树的前序遍历
 * Author: 行空XKong
 * Date: 2024-08-27
 * Time: 21:15
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

    public int[] preorderTraversal(TreeNode root) {
        // // 方法一（递归）
        // if (root == null) {
        //     return new int[0];
        // }
        // nums.add(root.val);
        // preorderTraversal(root.left);
        // preorderTraversal(root.right);
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
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            nums.add(node.val);
            // 栈先进后出所以先压右节点
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        int[] ret = new int[nums.size()];
        for (int i = 0; i < nums.size(); ++i) {
            ret[i] = nums.get(i);
        }
        return ret;
    }
}

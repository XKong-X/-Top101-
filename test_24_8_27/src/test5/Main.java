package test5;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: BM28 二叉树的最大深度
 * Author: 行空XKong
 * Date: 2024-08-27
 * Time: 23:39
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
    public int maxDepth(TreeNode root) {
        // // 方法一（递归）
        // if (root == null) {
        //     return 0;
        // }
        // return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        // 方法二（队列（层序遍历））
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();// 每层的节点数
            for (int i = 0; i < n; ++i) {
                TreeNode node = queue.poll();
                // 把每个节点的左右非空子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ++count;// 遍历完一层深度+1
        }
        return count;
    }
}

package test1;

/**
 * Created with IntelliJ IDEA.
 * Description: BM30 二叉搜索树与双向链表
 * Author: 行空XKong
 * Date: 2024-08-28
 * Time: 16:53
 * Version:
 */

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    private TreeNode head = null;
    private TreeNode prev = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        // // 方法一（递归）
        // if (pRootOfTree == null) {
        //     return pRootOfTree;
        // }
        // // 走到最左边
        // Convert(pRootOfTree.left);
        // if (prev == null) {
        //     head = pRootOfTree;
        //     prev = pRootOfTree;
        // } else {
        //     prev.right = pRootOfTree;
        //     pRootOfTree.left = prev;
        //     prev = pRootOfTree;
        // }
        // // 往右走一步
        // Convert(pRootOfTree.right);
        // return head;

        // 方法二（栈）
        if (pRootOfTree == null) return null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (pRootOfTree != null || !s.isEmpty()) {
            // 走到最左边
            while (pRootOfTree != null) {
                s.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            pRootOfTree = s.pop();
            // 最左元素即表头
            if (prev == null) {
                head = pRootOfTree;
                prev = head;
            } else {
                prev.right = pRootOfTree;
                pRootOfTree.left = prev;
                prev = pRootOfTree;
            }
            // 往右走一步
            pRootOfTree = pRootOfTree.right;
        }
        return head;
    }
}


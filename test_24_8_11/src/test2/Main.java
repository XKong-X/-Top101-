package test2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: BM13 判断一个链表是否为回文结构
 * Author: 行空XKong
 * Date: 2024-08-11
 * Time: 21:42
 * Version:
 */

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean isPail(ListNode head) {
        // // 方法一(未知原因导致位数稍微多点的负数过不了测试,且官方代码也跑不过)
        // // 存入数组
        // List<Integer> list = new ArrayList<>();
        // ListNode tmp = head;
        // while (tmp != null) {
        //     System.out.print(tmp.val + " ");
        //     list.add(tmp.val);
        //     tmp = tmp.next;
        // }
        // int left = 0;
        // int right = list.size() - 1;
        // while (left < right) {
        //     if (list.get(left) != list.get(right)) {
        //         return false;
        //     }
        //     ++left;
        //     --right;
        // }
        // return true;

        // // 方法二(快慢指针)
        // ListNode slow = head;
        // ListNode fast = head;
        // while (fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // slow = reverse(slow);
        // while (slow != null) {
        //     if (slow.val != head.val) {
        //         return false;
        //     }
        //     slow = slow.next;
        //     head = head.next;
        // }
        // return true;

        // 方法三(栈)
        ListNode tmp = head;
        Stack<Integer> stack = new Stack<>();
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        int count = 0;
        while (count < stack.size() / 2) {// 对比一半即可
            if (stack.pop() != head.val) {
                return false;
            }
            ++count;
            head = head.next;
        }
        return true;
    }

//    private ListNode reverse(ListNode tmp) {
//        ListNode prev = null;
//        while (tmp != null) {
//            ListNode tmpNext = tmp.next;
//            tmp.next = prev;
//            prev = tmp;
//            tmp = tmpNext;
//        }
//        return prev;
//    }
}

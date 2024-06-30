package test1;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: BM11 链表相加(二)
 * Author: 行空XKong
 * Date: 2024-06-30
 * Time: 23:26
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
    public ListNode addInList(ListNode head1, ListNode head2) {
        // // 方法一（反转链表法）
        // if (head1 == null) {
        //     return head2;
        // }
        // if (head2 == null) {
        //     return head1;
        // }
        // head1 = reverseList(head1);
        // head2 = reverseList(head2);
        // // 添加表头
        // ListNode ret = new ListNode(-1);
        // ListNode newHead = ret;
        // // 链表不为空或者有进位
        // int carry = 0;
        // while (head1 != null || head2 != null || carry != 0) {
        //     int val1 = head1 == null ? 0 : head1.val;
        //     int val2 = head2 == null ? 0 : head2.val;
        //     // 求和
        //     int sum = val1 + val2 + carry;
        //     // 求本位和进位
        //     int tmp = sum % 10;
        //     carry = sum / 10;
        //     // 添加
        //     newHead.next = new ListNode(tmp);
        //     newHead = newHead.next;
        //     // 移动
        //     if (head1 != null) {
        //         head1 = head1.next;
        //     }
        //     if (head2 != null) {
        //         head2 = head2.next;
        //     }
        // }
        // // 去掉表头并把链表翻转回来
        // return reverseList(ret.next);

        // // 方法二（栈（运行速度和占用内存都比方法一慢几倍））
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        ListNode ret = new ListNode(-1);
        ListNode head = ret;
        // 分别存入栈
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(tmp1 != null) {
            stack1.push(tmp1.val);
            tmp1 = tmp1.next;
        }
        while(tmp2 != null) {
            stack2.push(tmp2.val);
            tmp2 = tmp2.next;
        }
        int carry = 0;
        tmp1 = head1;
        tmp2 = head2;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = val1 + val2 + carry;
            int tmp = sum % 10;
            carry = sum / 10;
            head.next = new ListNode(tmp);
            head = head.next;
            System.out.print("...");
        }
        return reverseList(ret.next);
    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode tmp = head;
        while (tmp != null) {
            ListNode tmpNext = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = tmpNext;
        }
        return prev;
    }
}

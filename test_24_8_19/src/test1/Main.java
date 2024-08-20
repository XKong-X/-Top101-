package test1;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: BM14 链表的奇偶重排
 * Author: 行空XKong
 * Date: 2024-08-19
 * Time: 0:14
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
    public ListNode oddEvenList(ListNode head) {
        // // 方法一(双链表)
        // if (head == null) {
        //     return head;
        // }
        // ListNode list1 = new ListNode(-1);
        // ListNode list2 = new ListNode(-2);
        // ListNode head1 = list1;
        // ListNode head2 = list2;
        // ListNode tmp = head;
        // long index = 1;
        // while (tmp != null) {
        //     if (index % 2 == 1) {
        //         list1.next = tmp;
        //         list1 = list1.next;
        //     } else {
        //         list2.next = tmp;
        //         list2 = list2.next;
        //     }
        //     ++index;
        //     tmp = tmp.next;
        // }
        // list1.next = head2.next;
        // return head1.next;

        // 方法二（双指针）
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

// 用于验证方法一代码是正确的
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        for (int i = 0; i < 3; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        tmp = head.next;
        for (int i = 0; i < 3; i++) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        ListNode node = new Solution().oddEvenList(head.next);
        for (int i = 0; i < 3; i++) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}

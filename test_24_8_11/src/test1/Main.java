package test1;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: BM12 单链表的排序
 * Author: 行空XKong
 * Date: 2024-08-11
 * Time: 17:30
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
    public ListNode sortInList(ListNode head) {
        // // 方法一（转化为数组）
        // ListNode tmp = head;
        // // 存入数组
        // List<Integer> list = new ArrayList<>();
        // while (tmp != null) {
        //     list.add(tmp.val);
        //     tmp = tmp.next;
        // }
        // // 排序
        // list.sort(null);
        // // Collections.sort(list);
        // // 将排好序的数据插入回去
        // tmp = head;
        // for (int i = 0; i < list.size(); ++i) {
        //     tmp.val = list.get(i);
        //     tmp = tmp.next;
        // }
        // return head;

        // 方法二（归并排序）
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midPrev = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        // right 走到末尾时 mid 刚好在最中间
        while (right != null && right.next != null) {
            midPrev = midPrev.next;
            mid = mid.next;
            right = right.next.next;
        }
        // 断开链表
        midPrev.next = null;
        // 合并两段链表并返回
        return func(sortInList(head), sortInList(mid));
    }

    // 合并链表
    private ListNode func(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return newHead.next;
    }
}

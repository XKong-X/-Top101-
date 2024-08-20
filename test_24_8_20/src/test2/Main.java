package test2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: BM16 删除有序链表中重复的元素-II
 * Author: 行空XKong
 * Date: 2024-08-20
 * Time: 16:35
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
    public ListNode deleteDuplicates(ListNode head) {
        // // 方法一（哈希表）
        // if (head == null) {
        //     return head;
        // }
        // Map<Integer, Integer> map = new HashMap<>();
        // ListNode cur = head;
        // // 统计数据出现次数
        // while (cur != null) {
        //     if (map.containsKey(cur.val)) {
        //         map.put(cur.val, map.get(cur.val) + 1);
        //     } else {
        //         map.put(cur.val, 1);
        //     }
        //     cur = cur.next;
        // }
        // ListNode newHead = new ListNode(-1);
        // newHead.next = head;
        // cur = newHead;// 处理第一个数据重复的问题
        // while (cur.next != null) {
        //     if (map.get(cur.next.val) != 1) {
        //         cur.next = cur.next.next;
        //     } else {
        //         cur = cur.next;
        //     }
        // }
        // return newHead.next;

        // 方法二（直接比较删除）
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int tmp = cur.next.val;// 重复的数值
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}

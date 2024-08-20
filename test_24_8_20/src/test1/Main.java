package test1;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: BM15 删除有序链表中重复的元素-I
 * Author: 行空XKong
 * Date: 2024-08-20
 * Time: 12:06
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
        // HashSet<Integer> set = new HashSet<>();
        // ListNode cur = head;
        // set.add(cur.val);
        // while (cur != null && cur.next != null) {
        //     if (set.contains(cur.next.val)) {
        //         cur.next = cur.next.next;
        //     } else {
        //         set.add(cur.next.val);
        //         cur = cur.next;
        //     }
        // }
        // return head;

        // 方法二（遍历删除）
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}

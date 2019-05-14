/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, b = null, tail = null;
        ListNode p = l1;
        ListNode q = l2;
        int c = 0;
        while(p != null && q != null) {
            int temp = p.val + q.val + c;
            if(temp >= 10) {
                temp -= 10;
                c = 1;
            } else {
                c = 0;
            }
            b = new ListNode(temp);
            if (res == null) {
                res = b;
                tail = res;
            } else {
                tail.next = b;
                tail = b;
            }
            p = p.next;
            q = q.next;
        }
        while(p != null) {
            int temp = p.val + c;
            if(temp >= 10) {
                temp -= 10;
                c = 1;
            } else {
                c = 0;
            }
            b = new ListNode(temp);
            if (res == null) {
                res = b;
                tail = res;
            } else {
                tail.next = b;
                tail = b;
            }
            p = p.next;
        }
        while(q != null) {
            int temp = q.val + c;
            if(temp >= 10) {
                temp -= 10;
                c = 1;
            } else {
                c = 0;
            }
            b = new ListNode(temp);
            if (res == null) {
                res = b;
                tail = res;
            } else {
                tail.next = b;
                tail = b;
            }
            q = q.next;
        }
        if(c == 1) {
            b = new ListNode(c);
            if (res == null) {
                res = b;
                tail = res;
            } else {
                tail.next = b;
                tail = b;
            }
        }
        return res;
    }
}


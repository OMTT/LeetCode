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
        while(p != null || q != null || c == 1) {
            if(p != null) {
                c += p.val;
                p = p.next;
            }
            if(q != null) {
                c += q.val;
                q = q.next;
            }
            if(res == null) {
                res = new ListNode(c % 10);
                tail = res;
            } else {
                b = new ListNode(c % 10);
                tail.next = b;
                tail = b;
            }
            c = c / 10;
        }
        return res;
    }
}


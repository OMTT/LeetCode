/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (34.78%)
 * Likes:    1175
 * Dislikes: 87
 * Total Accepted:    193.9K
 * Total Submissions: 555.5K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head != null) {
            ListNode p = null;
            for(int i = 1; i < m; i++) {
                if(p == null) {
                    p = head;
                } else {
                    p = p.next;
                }
            }
            ListNode b = p;
            if(b == null) {
                b = head;
            } else {
                b = b.next;
            }
            ListNode q = b;
            for(int i = m+1; i <= n; i++) {
                q = q.next;
                b.next = q.next;
                if(p == null) {
                    q.next = head;
                    head = q;
                } else {
                    q.next = p.next;
                    p.next = q;
                }
                q = b;
            }
        }
        return head;
    }
}


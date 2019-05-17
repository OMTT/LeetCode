/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (44.43%)
 * Likes:    1092
 * Dislikes: 99
 * Total Accepted:    310.3K
 * Total Submissions: 697.5K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        if(p != null) {
            ListNode q = p.next;
            ListNode pre = p;
            while(q != null) {
                if(p == pre) {
                    head = q;
                } else {
                    pre.next = q;
                }
                p.next = q.next;
                q.next = p;
                pre = p;
                if(pre.next == null) {
                    q = null;
                } else {
                    p = pre.next;
                    q = p.next;
                }
            }
        }
        return head;
    }
}


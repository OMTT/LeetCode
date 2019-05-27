/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (37.08%)
 * Likes:    647
 * Dislikes: 174
 * Total Accepted:    163.2K
 * Total Submissions: 438.8K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if(head != null) {
            ListNode b = head;
            ListNode p = null;
            while(b != null && b.val < x) {
                p = b;
                b = b.next;
            }
            if(b != null) {
                ListNode q = b.next;
                while(q != null) {
                    if(q.val < x) {
                        b.next = q.next;
                        if(p != null) {   
                            q.next = p.next;
                            p.next = q;
                        } else {
                            q.next = head;
                            head = q;
                        }
                        p = q;
                        q = b.next;
                    } else {
                        b = q;
                        q = b.next;
                    }
                }
            }
        }
        return head;
    }
}


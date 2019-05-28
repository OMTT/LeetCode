/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (32.87%)
 * Likes:    814
 * Dislikes: 72
 * Total Accepted:    181.7K
 * Total Submissions: 550.3K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head != null) {
            ListNode b = head;
            ListNode p = null, q = null;
            while(b != null) {
                q = b;
                while(q.next != null && q.next.val == q.val) {
                    q = q.next;
                }
                if(q != b) {
                    if(p == null) {
                        head = q.next;
                    } else {
                        p.next = q.next;
                    }
                    b = q.next;
                } else {
                    p = q;
                    b = q.next;
                }
                
            }
        }
        return head;
    }
}


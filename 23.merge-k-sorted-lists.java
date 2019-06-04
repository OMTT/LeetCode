/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (34.24%)
 * Likes:    2460
 * Dislikes: 161
 * Total Accepted:    390.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        if(lists != null && lists.length >= 1) {
            for(int i = 0; i < lists.length; i++) {
                if(res == null) {
                    res = lists[i];
                } else {
                    ListNode b = lists[i];
                    res = merge(res, b);
                }
                
            }
        }
        return res;
    }

    public ListNode merge(ListNode res, ListNode b) {
        ListNode p = res;
        ListNode pre = null;
        while(p != null && b != null) {
            if(b.val <= p.val) {
                ListNode temp = b;
                b = b.next;
                temp.next = p;
                if(pre != null) {
                    pre.next = temp;
                } else {
                    res = temp;
                }
                pre = temp;
            } else {
                pre = p;
                p = p.next;
            }
        }
        if(p == null && b != null) {
            pre.next = b;
        }
        return res;
    }
}


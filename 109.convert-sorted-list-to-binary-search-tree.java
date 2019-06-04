import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (40.59%)
 * Likes:    992
 * Dislikes: 67
 * Total Accepted:    176.5K
 * Total Submissions: 431.7K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode b = head;
        TreeNode root = null;
        if(b != null) {
            List<Integer> lists = new ArrayList<>();
            while(b != null) {
                lists.add(b.val);
            }
            int[] nums = new int[lists.size()];
            for(int i = 0; i < nums.length; i++) {
                nums[i] = lists.get(i);
            }
            root = sortedListToBST(nums, 0, nums.length-1);
        }
        return root;
    }

    public TreeNode sortedListToBST(int[] nums, int start, int end) {
        TreeNode root = null;
        if(start > end) {
            int mid = (start+end)/2;
            root = new TreeNode(nums[mid]);
            root.left = sortedListToBST(nums, start, mid-1);
            root.right = sortedListToBST(nums, mid+1, end);
        }
        return root;
    }

}


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (25.65%)
 * Likes:    1919
 * Dislikes: 292
 * Total Accepted:    405.8K
 * Total Submissions: 1.6M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Input: [2,1,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * 
 * 
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
    public boolean isValidBST(TreeNode root) {
        if(root != null) {
            TreeNode b = root;
            int lastVisit = 0;
            boolean flag = false;
            Stack<TreeNode> stack = new Stack<>();
            while(b != null || !stack.isEmpty()) {
                while(b != null) {
                    stack.push(b);
                    b = b.left;
                }
                b = stack.pop();
                if(!flag) {
                    lastVisit = b.val;
                    flag = true;
                } else {
                    if(b.val <= lastVisit) {
                        return false;
                    } else {
                        lastVisit = b.val;
                    }
                }
                b = b.right;
            }
        }
        return true;
    }
}


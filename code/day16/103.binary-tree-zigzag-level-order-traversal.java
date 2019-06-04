import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (41.52%)
 * Likes:    938
 * Dislikes: 59
 * Total Accepted:    219.6K
 * Total Submissions: 525.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            boolean flag = true;
            TreeNode b = root;
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            List<Integer> temp = new ArrayList<>();
            s1.push(b);
            while(!s1.empty() || !s2.empty()) {
                if(flag) {
                    b = s1.pop();
                    temp.add(b.val);
                    if(b.left != null) {
                        s2.push(b.left);
                    }
                    if(b.right != null) {
                        s2.push(b.right);
                    }
                    if(s1.empty()) {
                        flag = false;
                        res.add(temp);
                        temp = new ArrayList<>();
                    }
                } else if(!flag) {
                    b = s2.pop();
                    temp.add(b.val);
                    if(b.right != null) {
                        s1.push(b.right);
                    }
                    if(b.left != null) {
                        s1.push(b.left);
                    }
                    
                    if(s2.empty()) {
                        flag = true;
                        res.add(temp);
                        temp = new ArrayList<>();
                    }
                }
            }
        }
        return res;
    }
}


import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (56.40%)
 * Likes:    1582
 * Dislikes: 69
 * Total Accepted:    458.4K
 * Total Submissions: 810.4K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode b = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(b != null || !stack.empty()) {
            while(b != null) {
                stack.push(b);
                b = b.left;
            }
            if(!stack.empty()) {
                b = stack.pop();
                res.add(b.val);
                b = b.right; 
            }
        }
        return res;
    }
}


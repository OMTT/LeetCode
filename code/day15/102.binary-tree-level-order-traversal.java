import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (48.25%)
 * Likes:    1458
 * Dislikes: 38
 * Total Accepted:    377.3K
 * Total Submissions: 778.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
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
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            TreeNode b = root;
            queue1.offer(b);
            List<Integer> tempRes = new ArrayList<>();
            int flag = 0;
            while(!queue1.isEmpty()||!queue2.isEmpty()) {
                if(flag == 0) {
                    b = queue1.poll();
                    if(b.left != null) {
                        queue2.offer(b.left);
                    }
                    if(b.right != null) {
                        queue2.offer(b.right);
                    }
                    tempRes.add(b.val);
                    if(queue1.isEmpty()) {
                        res.add(tempRes);
                        tempRes = new ArrayList<>();
                        flag = 1;
                    }
                } else {
                    b = queue2.poll();
                    if(b.left != null) {
                        queue1.offer(b.left);
                    }
                    if(b.right != null) {
                        queue1.offer(b.right);
                    }
                    tempRes.add(b.val);
                    if(queue2.isEmpty()) {
                        res.add(tempRes);
                        tempRes = new ArrayList<>();
                        flag = 0;
                    }
                }
            }
        }
        return res;
    }
}


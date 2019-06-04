import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 *
 * algorithms
 * Medium (42.32%)
 * Likes:    667
 * Dislikes: 24
 * Total Accepted:    185.6K
 * Total Submissions: 436.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number
 * 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * 
 * Example 2:
 * 
 * 
 * Input: [4,9,0,5,1]
 * ⁠   4
 * ⁠  / \
 * ⁠ 9   0
 * / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
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
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int count = 1;
            while(count > 0) {
                TreeNode b = queue.remove();
                count--;
                if(b.left == null && b.right == null) {
                    res += b.val;
                } else {
                    if(b.left != null) {
                        b.left.val += b.val * 10;
                        queue.add(b.left);
                        count++;
                    }
                    if(b.right != null) {
                        b.right.val += b.val * 10;
                        queue.add(b.right);
                        count++;
                    }
                }
            }
        }
        return res;
    }
}


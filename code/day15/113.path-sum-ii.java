import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (40.43%)
 * Likes:    878
 * Dislikes: 33
 * Total Accepted:    231.3K
 * Total Submissions: 569.2K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(res, new ArrayList<>(), root, sum);
        return res;
    }

    public void pathSum(List<List<Integer>> res, List<Integer> temp, TreeNode b, int sum) {
        if(b != null && b.left == null && b.right == null && b.val == sum) {
            temp.add(b.val);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        } else if(b != null) {
            temp.add(b.val);
            pathSum(res, temp, b.left, sum-b.val);
            pathSum(res, temp, b.right, sum-b.val);
            temp.remove(temp.size()-1);
        }
    }
}


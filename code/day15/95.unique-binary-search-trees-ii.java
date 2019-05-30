import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (35.54%)
 * Likes:    1214
 * Dislikes: 111
 * Total Accepted:    138.5K
 * Total Submissions: 387.9K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            res.addAll(generateTrees(i, 1, n));
        }
        return res;
    }
    
    public List<TreeNode> generateTrees(int root, int lowerRange, int upperRange) {
        List<TreeNode> res = new ArrayList<>();
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        for(int i = lowerRange; i < root; i++) {
            left.addAll(generateTrees(i, lowerRange, root-1));
        }
        for(int i = root+1; i <= upperRange; i++) {
            right.addAll(generateTrees(i, root+1, upperRange));
        }
        if(!left.isEmpty() && !right.isEmpty()) {
            for(TreeNode leftNode : left) {
                for(TreeNode rightNode : right) {
                    TreeNode b = new TreeNode(root);
                    b.left = leftNode;
                    b.right = rightNode;
                    res.add(b);
                }
            }
        } else if(!left.isEmpty()) {
            for(TreeNode leftNode : left) {
                TreeNode b = new TreeNode(root);
                b.left = leftNode;
                b.right = null;
                res.add(b);
            }
        } else if(!right.isEmpty()) {
            for(TreeNode rightNode : right) {
                TreeNode b = new TreeNode(root);
                b.left = null;
                b.right = rightNode;
                res.add(b);
            }
        } else {
            TreeNode b = new TreeNode(root);
            b.left = null;
            b.right = null;
            res.add(b);
        }
        return res;
    }
}


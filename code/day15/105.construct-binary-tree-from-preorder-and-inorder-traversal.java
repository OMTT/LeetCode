/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (40.83%)
 * Likes:    1696
 * Dislikes: 47
 * Total Accepted:    223.5K
 * Total Submissions: 543.4K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public int search(int[] inorder, int start, int end, int target) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        TreeNode b = null;
        if(start1 == end1 && start2 == end2) {
            b = new TreeNode(preorder[start1]);
        } else if(start1 < end1 && start2 < end2 && end1-start1 == end2-start2) {
            int index = search(inorder, start2, end2, preorder[start1]);
            int len = index - start2;
            b = new TreeNode(preorder[start1]);
            b.left = buildTree(preorder, start1+1, start1+len, inorder, start2, index-1);
            b.right = buildTree(preorder, start1+len+1, end1, inorder, index+1, end2);
        }
        return b;
    }
}


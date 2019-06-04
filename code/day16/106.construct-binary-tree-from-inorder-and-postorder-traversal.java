/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (39.06%)
 * Likes:    849
 * Dislikes: 18
 * Total Accepted:    153.4K
 * Total Submissions: 390.2K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        TreeNode res = null;
        if(start1 == end1 && start2 == end2) {
            res = new TreeNode(inorder[start1]);
        } else if((end1 - start1) == (end2 - start2) && end2 > start2) {
            int index = search(inorder, start1, end1, postorder[end2]);
            res = new TreeNode(postorder[end2]);
            res.left = buildTree(inorder, start1, index-1, postorder, start2, start2+index-start1-1);
            res.right = buildTree(inorder, index+1, end1, postorder, index-end1+end2, end2-1);
        }
        return res;
    }
    
    public int search(int[] inorder, int start, int end, int target) {
        int res = -1;
        for(int i = start; i <= end; i++) {
            if(inorder[i] == target) {
                res = i;
                break;
            }
        }
        return res;
    }
}


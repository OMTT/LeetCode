/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (46.02%)
 * Likes:    1687
 * Dislikes: 67
 * Total Accepted:    199.3K
 * Total Submissions: 431.3K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
class Solution {
    public int numTrees(int n) {
        if(n <= 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 2; i <= n; i++) {
            int temp = 0;
            for(int j = 0; j <= i-1; j++) {
                if(j == 0 || j == i-1) {
                    temp += res[i-1-1];
                } else {
                    temp = temp + res[j-1] * res[i-1-j-1];
                }
            }
            res[i-1] = temp;
        }
        return res[n-1];
    }
}


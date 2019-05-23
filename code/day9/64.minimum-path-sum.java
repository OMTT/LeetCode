/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (46.65%)
 * Likes:    1328
 * Dislikes: 38
 * Total Accepted:    229.2K
 * Total Submissions: 489.8K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] pathSum = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    pathSum[0][0] = grid[0][0];
                } else if(i == 0) {
                    pathSum[i][j] = grid[i][j] + pathSum[i][j-1];
                } else if(j == 0) {
                    pathSum[i][j] = grid[i][j] + pathSum[i-1][j];
                } else {
                    pathSum[i][j] = Math.min(pathSum[i-1][j], pathSum[i][j-1]) + grid[i][j];
                }
            }
        }
        return pathSum[m-1][n-1];
    }
}


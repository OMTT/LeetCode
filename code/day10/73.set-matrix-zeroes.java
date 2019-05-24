/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (39.65%)
 * Likes:    1026
 * Dislikes: 190
 * Total Accepted:    207.8K
 * Total Submissions: 522.8K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to
 * 0. Do it in-place.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output: 
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output: 
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int rowIndex = -1, colIndex = -1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    if(rowIndex == -1 && colIndex == -1) {
                        rowIndex = i;
                        colIndex = j;
                    } else {
                        matrix[i][colIndex] = 0;
                        matrix[rowIndex][j] = 0;
                    }
                }
            }
        }
        
        if(colIndex != -1 && rowIndex != -1) {
            for(int i = 0; i < m; i++) {
                if(i == rowIndex) {
                    continue;
                }
                if(matrix[i][colIndex] == 0) {
                    for(int j = 0; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for(int j = 0; j < n; j++) {
                if(j == colIndex) {
                    continue;
                }
                if(matrix[rowIndex][j] == 0) {
                    for(int i = 0; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for(int i = 0; i < m; i++) {
                matrix[i][colIndex] = 0;
            }
            for(int j = 0; j < n; j++) {
                matrix[rowIndex][j] = 0;
            }
        }
    }
}


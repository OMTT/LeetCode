/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (46.37%)
 * Likes:    431
 * Dislikes: 80
 * Total Accepted:    135.5K
 * Total Submissions: 291.6K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n >= 1) {
            int len = 0;
            if(n % 2 == 1) {
                len = n/2 + 1;
            } else {
                len = n/2;
            }
            int element = 1;
            for(int i = 0; i < len; i++) {
                element = traveleRound(res, element, i, i, n-1-i, n-1-i);
            }
        }
        return res;
    }

    public int traveleRound(int[][] res, int element, int left, int top, int right, int bottom) {
        if(left == right && top == bottom) {
            res[top][left] = element;
        } else if(left == right) {
            for(int i = top; i <= bottom; i++) {
                res[i][left] = element;
                element++;
            }
        } else if(top == bottom) {
            for(int i = left; i <= right; i++) {
                res[top][i] = element;
                element++;
            }
        } else {
            for(int i = left; i < right; i++) {
                res[top][i] = element;
                element++;
            }
            for(int i = top; i < bottom; i++) {
                res[i][right] = element;
                element++;
            }
            for(int i = right; i > left; i--) {
                res[bottom][i] = element;
                element++;
            }
            for(int i = bottom; i > top; i--) {
                res[i][left] = element;
                element++;
            }
        }
        return element;
    }
}


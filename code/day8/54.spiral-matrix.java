import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (30.30%)
 * Likes:    1056
 * Dislikes: 403
 * Total Accepted:    231.9K
 * Total Submissions: 763.4K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix != null && matrix.length > 0) {
            int m = matrix.length;
            int n = matrix[0].length;
            int len = Math.min(m, n);
            if(len % 2 == 1) {
                len = len/2+1;
            } else {
                len = len/2;
            }
            for(int index = 0; index < len; index++) {
                res.addAll(scanRound(matrix, index, index, n-1-index, m-1-index));
            }
        }
        return res;
    }

    public List<Integer> scanRound(int[][] matrix, int left, int top, int right, int bottom) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        if(left == right && top == bottom) {
            res.add(matrix[left][top]);
        } else if(left == right) {
            for(i = top; i <= bottom; i++) {
                res.add(matrix[i][left]);
            }
        } else if(top == bottom) {
            for(i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
        } else {
            for(i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            for(i = top; i < bottom; i++) {
                res.add(matrix[i][right]);
            }
            for(i = right; i > left; i--) {
                res.add(matrix[bottom][i]);
            }
            for(i = bottom; i > top; i--) {
                res.add(matrix[i][left]);
            }
        }
        return res;
    }
}


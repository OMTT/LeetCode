import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (39.16%)
 * Likes:    1107
 * Dislikes: 120
 * Total Accepted:    182.2K
 * Total Submissions: 462.6K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = 0;
        int n = triangle.size();
        if(n > 0) {
            List<Integer> pathSum = triangle.get(n-1);
            for(int i = n-2; i >= 0; i--) {
                List<Integer> row = triangle.get(i);
                for(int j = 0; j < row.size(); j++) {
                    int temp = Math.min(pathSum.get(j), pathSum.get(j+1)) + row.get(j);
                    row.set(j, temp);
                }
                pathSum = row;
            }
            res = pathSum.get(0);
        }
        return res;
    }
}


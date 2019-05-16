/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (44.22%)
 * Likes:    3174
 * Dislikes: 428
 * Total Accepted:    363.5K
 * Total Submissions: 821.1K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * 
 * 
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In
 * this case, the max area of water (blue section) the container can contain is
 * 49. 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 */
class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int contain = Math.min(height[0], height[1]);
        for(int i = 2; i < height.length; i++) {
            for(int j = 0; j < i; j++) {
                contain = Math.max(contain, Math.min(height[i], height[j])*(i-j));
            }
        }
        return contain;
    }
}


/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (31.81%)
 * Likes:    1878
 * Dislikes: 192
 * Total Accepted:    261.4K
 * Total Submissions: 820.7K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        boolean[] arrive = new boolean[nums.length];
        arrive[0] = true;
        for(int i = 0; i < nums.length-1; i++) {
            if(arrive[i]) {
                for(int j = 1; j <= nums[i] && i+j < nums.length; j++) {
                    arrive[i+j] = true;
                }
            }
        }
        return arrive[nums.length-1];
    }
}


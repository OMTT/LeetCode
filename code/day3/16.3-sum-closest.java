/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.33%)
 * Likes:    1065
 * Dislikes: 80
 * Total Accepted:    341.1K
 * Total Submissions: 750.1K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = target;
        for(int i = 0; i < nums.length-2; i++) {
            int ls = i+1, le = nums.length-1;
            while(ls < le) {
                int temp = nums[i] + nums[ls] + nums[le];
                if(temp == target) {
                    return target;
                } else if(temp < target) {
                    ls++;
                } else {
                    le--;
                }
                if(sum == target || Math.abs(temp-target) < Math.abs(sum-target)) {
                    sum = temp;
                }
            }
        }
        return sum;
    }
}


/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (33.46%)
 * Likes:    1528
 * Dislikes: 85
 * Total Accepted:    296.5K
 * Total Submissions: 885.7K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int index = -1;
        int startIndex = -1;
        int endIndex = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                index = mid;
                break;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(index != -1) {
            int i = index - 1;
            while(i >= 0 && nums[i] == nums[index]) {
                i--;
            }
            startIndex = i + 1;
            i = index + 1;
            while(i < nums.length && nums[i] == nums[index]) {
                i++;
            }
            endIndex = i-1;
        }
        return new int[]{startIndex, endIndex};
    }
}


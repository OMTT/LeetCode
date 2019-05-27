/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (32.60%)
 * Likes:    648
 * Dislikes: 305
 * Total Accepted:    170.9K
 * Total Submissions: 523.9K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
                for(int i = start; i <= end; i++) {
                    if(target == nums[i]) {
                        return true;
                    }
                }
                return false;
            } else if(target > nums[mid]) {
                if(target <= nums[end] || nums[mid] >= nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if(target < nums[mid]) {
                if(target >= nums[start] || nums[mid] <= nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}


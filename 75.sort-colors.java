/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (42.03%)
 * Likes:    1597
 * Dislikes: 154
 * Total Accepted:    316.4K
 * Total Submissions: 751.3K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */
class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length-1;
        int numOne = 0;
        while(start < end-numOne+1) {
            while(start < end-numOne+1 && nums[start] == 0) {
                start++;
            }
            while(start < end-numOne+1 && nums[end] == 2) {
                end--;
            }
            if(start < end-numOne+1) {
                if(nums[start] == 2) {
                    swap(nums, start, end);
                    end--;
                    if(nums[start] == 1 && numOne > 0) {
                        swap(nums, start, end-numOne+1);
                    }
                } else if(nums[start] == 1) {
                    swap(nums, start, end-numOne);
                    numOne++;
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


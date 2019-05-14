/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */
class Solution {
    public void nextPermutation(int[] nums) {
        nextPermutation(nums, 0);
    }

    public void nextPermutation(int[] nums, int index) {
        if(nums == null || nums.length - index < 2) {
            return;
        }
        boolean desorder = true;
        for(int i = index; i < nums.length-1; i++) {
            if(nums[i] < nums[i+1]) {
                desorder = false;
                break;
            }
        }
        if(!desorder) {
            if(nums.length-index == 2) {
                swap(nums, index, index+1);
            } else {
                nextPermutation(nums, index+1);
            }
            
        } else {
            for(int i = 0; i < (nums.length-index)/2; i++) {
                swap(nums, index+i, nums.length-1-i);
            }
            if(index > 0) {
                for(int i = index; i < nums.length; i++) {
                    if(nums[i] > nums[index-1]) {
                        swap(nums, i, index-1);
                        break;
                    }
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


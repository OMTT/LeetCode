import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (30.37%)
 * Likes:    1024
 * Dislikes: 207
 * Total Accepted:    230.7K
 * Total Submissions: 758.7K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length-3; i++) {
            // if(i > 0 && nums[i] == nums[i-1] && nums[i] == nums[i+1]) {
            //     continue;
            // }
            for(int j = i+1; j < nums.length-2; j++) {
                int ls = j+1, le = nums.length-1;
                while(ls < le) {
                    int temp = nums[i] + nums[j] + nums[le] + nums[ls];
                    if(temp == target) {
                        List<Integer> tempRes = new ArrayList<>();
                        tempRes.add(nums[i]);
                        tempRes.add(nums[j]);
                        tempRes.add(nums[ls]);
                        tempRes.add(nums[le]);
                        res.add(tempRes);
                        ls++;
                        while(ls < le && nums[ls] == nums[ls-1]) ls++;
                        le--;
                        while(ls < le && nums[le] == nums[le+1]) le--;
                    } else if(temp < target) {
                        ls++;
                        while(ls < le && nums[ls] == nums[ls-1]) ls++;
                    } else {
                        le--;
                        while(ls < le && nums[le] == nums[le+1]) le--;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> e : res) {
            result.add(e);
        }
        return result;
    }
}


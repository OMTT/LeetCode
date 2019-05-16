import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.91%)
 * Likes:    3702
 * Dislikes: 402
 * Total Accepted:    541.7K
 * Total Submissions: 2.3M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length-1] < 0) {
            return result;
        }
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if(nums[i] != 0 && i+2 < nums.length && nums[i] == nums[i+1] && nums[i] == nums[i+2]) {
                continue;
            }
            int ls = i+1, le = nums.length-1;
            while(ls < le) {
                if(nums[ls] + nums[le] + nums[i] < 0) {
                    ls++;
                } else if(nums[ls] + nums[le] + nums[i] > 0) {
                    le--;
                } else {
                    res.add(construction(nums[i], nums[ls], nums[le]));
                    ls++;
                    le--;
                }
            }
        }
        
        for(List<Integer> e : res) {
            result.add(e);
        }
        return result;
    }

    public List<Integer> construction(int a, int b, int c) {
        List<Integer> tempRes = new ArrayList<>(3);
        tempRes.add(a);
        tempRes.add(b);
        tempRes.add(c);
        return tempRes;
    }
}


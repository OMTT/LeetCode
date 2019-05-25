import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (52.52%)
 * Likes:    1873
 * Dislikes: 49
 * Total Accepted:    363.8K
 * Total Submissions: 690K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums != null && nums.length > 0) {
            List<Integer> temp;
            for(int i = 0; i < nums.length; i++) {
                int size = res.size();
                for(int j = 0; j < size; j++) {
                    temp = new ArrayList<>(res.get(j));
                    temp.add(nums[i]);
                    res.add(temp);
                }
                temp = new ArrayList<>();
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
}


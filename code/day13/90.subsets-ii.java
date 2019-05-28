import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (42.24%)
 * Likes:    866
 * Dislikes: 49
 * Total Accepted:    202.6K
 * Total Submissions: 478K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            Set<List<Integer>> tempRes = new HashSet<>();
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            tempRes.add(temp);
            for(List<Integer> e : res) {
                temp = new ArrayList<>(e);
                temp.add(nums[i]);
                tempRes.add(temp);
            }
            res.addAll(tempRes);
        }
        List<Integer> temp = new ArrayList<>();
        res.add(temp);
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }
}


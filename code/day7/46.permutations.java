import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (54.89%)
 * Likes:    1945
 * Dislikes: 59
 * Total Accepted:    375.1K
 * Total Submissions: 682.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(res.size() == 0) {
                tempRes.add(nums[i]);
                res.add(tempRes);
            } else {
                int n = res.size();
                for(int j = 0; j < n; j++) {
                    tempRes = res.get(0);
                    res.remove(0);
                    for(int k = 0; k <= tempRes.size(); k++) {
                        tempRes.add(k, nums[i]);
                        res.add(new ArrayList(tempRes));
                        tempRes.remove(k);
                    }
                }
            }
        }
        if(res.size() == 0) {
            res.add(tempRes);
        }
        return res;
    }
}


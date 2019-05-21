import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (40.27%)
 * Likes:    967
 * Dislikes: 43
 * Total Accepted:    240.8K
 * Total Submissions: 596.7K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();
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
                        res.add(new ArrayList<>(tempRes));
                        tempRes.remove(k);
                    }
                }
            }
        }
        if(res.size() == 0) {
            res.add(tempRes);
        } else {
            for(List<Integer> e : res) {
                resSet.add(e);
            }
            res.clear();
            for(List<Integer> e : resSet) {
                res.add(e);
            }
        }
        
        
        return res;
    }
}


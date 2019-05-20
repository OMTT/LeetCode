import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (48.17%)
 * Likes:    1936
 * Dislikes: 58
 * Total Accepted:    338K
 * Total Submissions: 699.8K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> selection = new Stack<Integer>();
        selection.push(0);
        int sum = candidates[0];
        while(!selection.isEmpty()) {
            int index = selection.peek();
            while(sum < target) {
                selection.push(index);
                sum += candidates[index];
            }
            if(sum == target) {
                List<Integer> tempRes = new ArrayList<>();
                for(int e : selection) {
                    tempRes.add(candidates[e]);
                }
                res.add(tempRes);
            }
            sum -= candidates[selection.pop()];
            if(!selection.isEmpty()) {
                index = selection.pop();
                sum -= candidates[index];
                while(index == candidates.length-1 && !selection.isEmpty()) {
                    index = selection.pop();
                    sum -= candidates[index];
                }
                if(index < candidates.length-1) {
                    sum += candidates[index+1];
                    selection.push(index+1);
                }
            }
        }
        return res;
    }
}


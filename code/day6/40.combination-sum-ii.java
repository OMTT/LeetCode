import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (41.34%)
 * Likes:    814
 * Dislikes: 43
 * Total Accepted:    218.8K
 * Total Submissions: 527.7K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
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
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Stack<Integer> selection = new Stack<>();
        Arrays.sort(candidates);
        int sum = 0;
        selection.push(0);
        sum += candidates[0];
        while(!selection.isEmpty()) {
            int index = selection.peek() + 1;
            while(index < candidates.length && sum < target) {
                sum += candidates[index];
                selection.push(index++);
            }
            if(sum == target) {
                List<Integer> tempRes = new ArrayList<>();
                for(int e : selection) {
                    tempRes.add(candidates[e]);
                }
                res.add(tempRes);
            }
            index = selection.pop();
            sum -= candidates[index];
            if(!selection.isEmpty()) {
                index = selection.pop();
                sum -= candidates[index];
                index++;
                selection.push(index);
                sum += candidates[index];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> e : res) {
            result.add(e);
        }
        return result;
    }
}


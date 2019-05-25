import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (47.36%)
 * Likes:    760
 * Dislikes: 42
 * Total Accepted:    201.3K
 * Total Submissions: 423.4K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k <= n && n >= 0) {
            boolean[] selection = new boolean[n];
            combine(res, new ArrayList<Integer>(), selection, k, 0);
        }
        return res;
    }

    public void combine(List<List<Integer>> res, List<Integer> temp, boolean[] selection, int k, int index) {
        
        if(k == 0) {
            res.add(new ArrayList<>(temp));
        } else {
            for(int i = index; i < selection.length; i++) {
                if(!selection[i]) {
                    selection[i] = true;
                    temp.add(i+1);
                    combine(res, temp, selection, k-1, i+1);
                    temp.remove(temp.size()-1);
                    selection[i] = false;
                }
            }
        }
    }
}


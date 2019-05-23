import java.util.List;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (32.93%)
 * Likes:    809
 * Dislikes: 220
 * Total Accepted:    137.1K
 * Total Submissions: 415.4K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */
class Solution {
    public String getPermutation(int n, int k) {
        if(n == 1) {
            return "1";
        }
        int[] fact = new int[n-1];
        fact[0] = 1;
        for(int i = 2; i <= n-1; i++) {
            fact[i-1] = fact[i-2] * i;
        }
        List<Integer> nums = new ArrayList<>(9);
        for(int i = 1; i <= 9; i++) {
            nums.add(i);
        }
        StringBuilder res = new StringBuilder();
        k--;
        for(int i = 0; i < n-1; i++) {
            int index = k/fact[n-2-i];
            res.append(nums.get(index));
            nums.remove(index);
            k = k%fact[n-2-i];
        }
        res.append(nums.get(0));
        return res.toString();
    }
}


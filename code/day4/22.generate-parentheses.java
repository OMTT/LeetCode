import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (54.64%)
 * Likes:    2685
 * Dislikes: 166
 * Total Accepted:    333.8K
 * Total Submissions: 610.3K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        if(n < 0) {
            List<String> res = new ArrayList<String>();
            res.add("");
            return res;
        }
        int[] pairParenthesis = new int[n*2];
        return pairs(pairParenthesis, 0, n, n);
    }

    public List<String> pairs(int[] pairParenthesis, int index, int left, int right) {
        List<String> res = new ArrayList<>();
        if(left <= 0 && right <= 0) {
            // System.out.println(pairParenthesis);
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < index; i++) {
                if(pairParenthesis[i] == 1) {
                    temp.append('(');
                } else {
                    temp.append(')');
                }
            }
            res.add(temp.toString());
        } else {
            List<String> tempRes;
            if(left > 0) {
                pairParenthesis[index] = 1;
                tempRes = pairs(pairParenthesis, index+1, left-1, right);
                res.addAll(tempRes);
            }
            if(right > 0 && left < right) {
                pairParenthesis[index] = -1;
                tempRes = pairs(pairParenthesis, index+1, left, right-1);
                res.addAll(tempRes);
            }
        }
        return res;
    }
}


import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (41.36%)
 * Likes:    2117
 * Dislikes: 287
 * Total Accepted:    383.9K
 * Total Submissions: 927K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] numMap =  {{'*'},
                            {'a','b','c'},
                            {'d','e','f'},
                            {'g','h','i'},
                            {'j','k','l'},
                            {'m','n','o'},
                            {'p','q','r','s'},
                            {'t','u','v'},
                            {'w','x','y','z'}};
        List<String> res = new ArrayList<String>();
        
        for(int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '1';
            if(index < 0 || index > 8) {
                return new ArrayList<String>();
            }
            int len = res.size();
            for(int k = 0; k < len; k++) {
                for(int j = 0; j < numMap[index].length; j++) {
                    StringBuilder temp = new StringBuilder(res.get(k));
                    temp.append(numMap[index][j]);
                    res.add(temp.toString());
                }
            }
            for(int k = 0; k < len; k++) {
                res.remove(0);
            }
            if(len == 0) {
                for(int j = 0; j < numMap[index].length; j++) {
                    StringBuilder temp = new StringBuilder();
                    temp.append(numMap[index][j]);
                    res.add(temp.toString());
                }
            }
        }
        return res;
    }
}


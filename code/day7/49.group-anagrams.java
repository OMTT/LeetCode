import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (46.43%)
 * Likes:    1595
 * Dislikes: 108
 * Total Accepted:    332.6K
 * Total Submissions: 714.1K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> tempRes;
        for(int i = 0; i < strs.length; i++) {
            int n = res.size();
            boolean flag = false;
            for(int j = 0; j < n && !flag; j++) {
                tempRes = res.get(j);
                if(StringEqual(tempRes.get(0), strs[i])) {
                    tempRes.add(strs[i]);
                    flag = true;
                }
            }
            if(!flag) {
                tempRes = new ArrayList<>();
                tempRes.add(strs[i]);
                res.add(tempRes);
            }
        }
        return res;
    }

    public boolean StringEqual(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        } else {
            int[] charArr = new int[26];
            for(int i = 0; i < 26; i++) {
                charArr[i] = 0;
            }
            for(int i = 0; i < str1.length(); i++) {
                charArr[str1.charAt(i)-'a']++;
                charArr[str2.charAt(i)-'a']--;
            }
            for(int i = 0; i < 26; i++) {
                if(charArr[i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}


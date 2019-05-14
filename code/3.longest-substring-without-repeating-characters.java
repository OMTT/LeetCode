/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        }
        StringBuilder selection = new StringBuilder();
        int index = 0;
        int len = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            
            String ch = s.substring(i, i+1);
            index = selection.indexOf(ch);
            
            if(index != -1) {
                selection.delete(0, index+1);
                selection.append(ch);
                len = len - index;
                res = Math.max(res, len);
            } else {
                selection.append(ch);
                len++;
                res = Math.max(res, len);
            }
        }
        return res;
    }
}


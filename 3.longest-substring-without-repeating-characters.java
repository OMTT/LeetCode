/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder selection = new StringBuilder();
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if((index = selection.indexOf() != -1) {
                selection.delete(0, index+1);
                
            }
        }
        return 1;
    }
}


import java.util.Set;

import javax.xml.stream.events.Characters;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> substr = new HashSet<Character>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length()) {
            if(!substr.contains(s.charAt(j))) {
                substr.add(s.charAt(j++));
                max = Math.max(max, substr.size());
            } else {
                substr.remove(s.charAt(i++));
            }
        }
        return max;
    }
}


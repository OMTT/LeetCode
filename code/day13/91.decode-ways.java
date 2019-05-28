/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.25%)
 * Likes:    1375
 * Dislikes: 1572
 * Total Accepted:    260.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    public int numDecodings(String s) {
        int[] decode = new int[s.length()];
        char[] digits = s.toCharArray();
        if(digits[0] == '0') {
            return 0;
        } else {
            decode[0] = 1;
        }
        if(s.length() > 1) {
            if(digits[1] == '0') {
                if(digits[0] == '1' || digits[0] == '2') {
                    decode[1] = 1;
                } else {
                    return 0;
                }
            } else if((digits[0]-'0')*10 + digits[1] - '0' <= 26) {
                decode[1] = 2;
            } else {
                decode[1] = 1;
            }
        }
        for(int i = 2; i < s.length(); i++) {
            if(digits[i] == '0') {
                if(digits[i-1] == '1' || digits[i-1] == '2') {
                    decode[i] = decode[i-2];
                } else {
                    return 0;
                }
            } else if(digits[i-1] == '0' || (digits[i-1]-'0')*10 + digits[i] - '0' > 26) {
                decode[i] = decode[i-1];
            } else {
                decode[i] = decode[i-1] + decode[i-2];
            }
        }
        return decode[s.length()-1];
    }
}


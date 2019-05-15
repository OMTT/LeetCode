/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (31.64%)
 * Likes:    1016
 * Dislikes: 3150
 * Total Accepted:    313.6K
 * Total Submissions: 990.9K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            int j = i;
            while(j < s.length()) {
                res.append(s.charAt(j));
                j += 2*(numRows-1);
                if(i > 0 && i < numRows-1) {
                    if(j-2*i < s.length()) {
                        res.append(s.charAt(j-2*i));
                    }
                }
            }
        }
        return res.toString();
    }
}


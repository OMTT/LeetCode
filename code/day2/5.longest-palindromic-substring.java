/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.20%)
 * Likes:    3529
 * Dislikes: 343
 * Total Accepted:    546.1K
 * Total Submissions: 2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        // A 2-D matrix to indicate whether a substring of s is a palindrome
        // the matrix has s.length() rows, the i-th row has s.length-i elements
        // the row index i indicates the length of the substring with i+1
        // the col index j indicates the start index of the substring in s
        // each element in the matrix is a boolean value
        boolean[][] flag = new boolean[s.length()][];

        // the elements in 0-th row is true where a string wiht a char element is a palindrome
        flag[0] = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++) {
            flag[0][i] = true;
        }

        if(s.length() > 1) {
            // the substring with two chars is a palindrome where the two chars is equal
            flag[1] = new boolean[s.length()-1];
            for(int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    flag[1][i] = true;
                } else {
                    flag[1][i] = false;
                }
            }
            // extends the palindrome by addind char in the start and end position of the substring
            // the new substring is a palindrome where the two new chars are equal
            for(int i = 2; i < s.length(); i++) {
                flag[i] = new boolean[s.length()-i];
                for(int j = 0; j < s.length()-i; j++) {
                    if(flag[i-2][j+1] && s.charAt(j) == s.charAt(j+i)) {
                        flag[i][j] = true;
                    } else {
                        flag[i][j] = false;
                    }
                }
            }
        }

        // traverse the matrix for the last row, find the first true value then break
        // return the substring according to the index i, j
        for(int i = s.length()-1; i >= 0; i--) {
            for(int j = 0; j < flag[i].length; j++) {
                if(flag[i][j]) {
                    return s.substring(j, j+i+1);
                }
            }
        }
        return "";
    }
}


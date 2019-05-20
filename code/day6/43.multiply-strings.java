/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (30.54%)
 * Likes:    963
 * Dislikes: 442
 * Total Accepted:    198.9K
 * Total Submissions: 650.2K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
        String res = "0";
        if(!num1.equals("0") && !num2.equals("0") && num1 != null && num2 != null) {
            for(int i = 0; i < num1.length(); i++) {
                res = add(res, multiply(num2, num1.charAt(num1.length()-1-i)) + zeroTail(i));
            }
        }
        return res;
    }

    public String multiply(String num1, char ch) {
        int c = 0;
        StringBuilder res = new StringBuilder();
        for(int i = num1.length()-1; i >= 0; i--) {
            int temp = (num1.charAt(i)-'0') * (ch-'0') + c;
            c = temp / 10;
            res.append(temp%10);
        }
        if(c > 0) {
            res.append(c);
        }
        res.reverse();
        return res.toString();
    }

    public String add(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int c = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 && j >= 0) {
            int temp = (num1.charAt(i)-'0') + (num2.charAt(j)-'0') + c;
            c = temp / 10;
            res.append(temp%10);
            i--;
            j--;
        }
        while(i >= 0) {
            int temp = (num1.charAt(i)-'0') + c;
            c = temp / 10;
            res.append(temp%10);
            i--;
        }
        while(j >= 0) {
            int temp = (num2.charAt(j)-'0') + c;
            c = temp / 10;
            res.append(temp%10);
            j--;
        }
        if(c > 0) {
            res.append(c);
        }
        res.reverse();
        return res.toString();
    }

    public String zeroTail(int n) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++) {
            res.append('0');
        }
        return res.toString();
    }
}


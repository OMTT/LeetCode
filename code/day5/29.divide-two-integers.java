/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.16%)
 * Likes:    654
 * Dislikes: 3105
 * Total Accepted:    194.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * 
 * Note:
 * 
 * 
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows.
 * 
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(dividend == 0) {
            return 0;
        }
        int signDividend = dividend>0?1:-1;;
        int signDivisor = divisor>0?1:-1;
        int sign = signDividend * signDivisor;
        int res = 0;
        
        dividend *= -signDividend;
        divisor *= -signDivisor;
        int origin = divisor;
        int multiple = 1;
        while(dividend <= origin) {
            while(dividend <= divisor) {
                res += multiple;
                dividend -= divisor;
                if(Integer.MIN_VALUE - divisor > divisor) {
                    break;
                }
                divisor = divisor + divisor;
                multiple = multiple + multiple;
            }
            divisor = origin;
            multiple = 1;
        }
        return res * sign;
    }
}


import java.math.BigDecimal;

/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (27.90%)
 * Likes:    828
 * Dislikes: 2048
 * Total Accepted:    317.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if(n == 0) {
            return 1.0;
        } else if (new BigDecimal(x).compareTo(new BigDecimal(0.0)) == 0 || new BigDecimal(x).compareTo(new BigDecimal(1.0)) == 0) {
            return x;
        } else if(n < 0) {
            return 1.0/(myPow(x, -(n+1))*x);
        } else {
            while(n > 0) {
                if((n & 1) == 1) {
                    res *= x;
                }
                x *= x;
                n = n >> 1;
            }
        }
        return res;
    }
}


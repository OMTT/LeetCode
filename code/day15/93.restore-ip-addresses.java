import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (31.34%)
 * Likes:    658
 * Dislikes: 264
 * Total Accepted:    139.6K
 * Total Submissions: 443.5K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for(int i1 = 1; i1 <= 3; i1++) {
            if(i1 > s.length()) {
                break;
            }
            String s1 = s.substring(0, i1);
            if(s1.startsWith("0") && s1.length() > 1) {
                continue;
            }
            if(Integer.parseInt(s1) > 255) {
                break;
            }
            for(int i2 = i1+1; i2 <= i1+3; i2++) {
                if(i2 > s.length()) {
                    break;
                }
                String s2 = s.substring(i1, i2);
                if(s2.startsWith("0") && s2.length() > 1) {
                    continue;
                }
                if(Integer.parseInt(s2) > 255) {
                    break;
                }
                for(int i3 = i2+1; i3 <= i2+3; i3++) {
                    if(i3 >= s.length()) {
                        break;
                    }
                    String s3 = s.substring(i2, i3);
                    if(s3.startsWith("0") && s3.length() > 1) {
                        continue;
                    }
                    if(Integer.parseInt(s3) > 255) {
                        break;
                    }
                    String s4 = s.substring(i3);
                    if(s4.length() > 3 || Integer.parseInt(s4) > 255 || s4.startsWith("0") && s4.length() > 1) {
                        continue;
                    }
                    String temp = s1 + "." + s2 + "." + s3 + "." + s4;
                    res.add(temp);
                }
            }
        }
        return res;
    }
}


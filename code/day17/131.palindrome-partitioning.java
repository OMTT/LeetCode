import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (40.64%)
 * Likes:    899
 * Dislikes: 36
 * Total Accepted:    164.4K
 * Total Submissions: 401.4K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s != null && s.length() > 0) {
            for(int i = s.length()-1; i >= 0; i--) {
                if(res.size() == 0) {
                    List<String> temp = new ArrayList<>();
                    temp.add(s.substring(i));
                    res.add(temp);
                } else {
                    String str = s.substring(i, i+1);
                    int size = res.size();
                    for(int j = 0; j < size; j++) {
                        List<String> e = res.get(j);
                        StringBuilder str0 = new StringBuilder(str);
                        for(int k = 0; k < e.size(); k++) {
                            str0.append(e.get(k));
                            if(isPalindrome(str0.toString())) {
                                List<String> temp = new ArrayList<>(e);
                                int count = k;
                                while(count >= 0) {
                                    temp.remove(0);
                                    count--;
                                }
                                temp.add(0, str0.toString());
                                if(!res.contains(temp)) {
                                    res.add(temp);
                                }
                            }
                        }
                        e.add(0, str);
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;
        while(i <= j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


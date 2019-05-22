import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (35.51%)
 * Likes:    2025
 * Dislikes: 156
 * Total Accepted:    344.4K
 * Total Submissions: 968.1K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> myIntervals = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) {
            if(!myIntervals.containsKey(intervals[i][0])) {
                myIntervals.put(intervals[i][0], intervals[i][1]);
            } else {
                Integer value = myIntervals.get(intervals[i][0]);
                if(intervals[i][1] > value) {
                    myIntervals.put(intervals[i][0], intervals[i][1]);
                }
            }
        }
        int[][] tempRes = new int[myIntervals.size()][2];
        int count = 0;
        for(int i : myIntervals.keySet()) {
            if(count == 0) {
                tempRes[count][0] = i;
                tempRes[count][1] = myIntervals.get(i);
                count++;
            } else {
                if(i <= tempRes[count-1][1]) {
                    tempRes[count-1][1] = Math.max(myIntervals.get(i), tempRes[count-1][1]);
                } else {
                    tempRes[count][0] = i;
                    tempRes[count][1] = myIntervals.get(i);
                    count++;
                }
            }
        }
        int[][] res = new int[count][2];
        for(int i = 0; i < count; i++) {
            res[i][0] = tempRes[i][0];
            res[i][1] = tempRes[i][1];
        }
        return res;
    }
}


/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (26.22%)
 * Likes:    4265
 * Dislikes: 565
 * Total Accepted:    432.4K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0) {
            if(nums2.length%2 == 1) {
                return (double)nums2[nums2.length/2];
            } else {
                return ((double)nums2[nums2.length/2 - 1] + (double)nums2[nums2.length/2])/2;
            }
        }
        if(nums2 == null || nums2.length == 0) {
            if(nums1.length%2 == 1) {
                return (double)nums1[nums1.length/2];
            } else {
                return ((double)nums1[nums1.length/2 - 1] + (double)nums1[nums1.length/2])/2;
            }
        }
        if(nums1.length > nums2.length) {
            return searchMedianSortedArrays(nums2, nums1);
        }
        return searchMedianSortedArrays(nums1, nums2);
    }

    public double searchMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        double res = 0;
        int start = 0, end = m;
        while(start <= end) {
            int i = (start+end)/2;
            int j = (m+n)/2 - i;
            if(i > 0 && i < m) {
                if(A[i-1] <= B[j] && A[i] >= B[j-1]) {
                    if((m+n)%2 == 1) {
                        res = (double)Math.min(A[i], B[j]);
                    } else {
                        res = ((double)Math.min(A[i], B[j])+(double)Math.max(A[i-1], B[j-1]))/2;
                    }
                    break;
                } else if(B[j-1] > A[i]) {
                    start = i + 1;
                } else if(A[i-1] > B[j]) {
                    end = i - 1;
                }
            } else if(i == 0) {
                if(j == n) {
                    if(A[i] >= B[j-1]) {
                        res = ((double)A[i]+(double)B[j-1])/2;
                        break;
                    } else {
                        start = i + 1;
                    }
                } else {
                    if(A[i] >= B[j-1]) {
                        if((m+n)%2 == 1) {
                            res = (double)Math.min(A[i], B[j]);
                        } else {
                            res = ((double)Math.min(A[i], B[j])+(double)B[j-1])/2;
                        }
                        break;
                    } else {
                        start = i + 1;
                    }
                }
            } else if(i == m) {
                if(j == 0) {
                    if(A[i-1] <= B[j]) {
                        if((m+n)%2 == 1) {
                            res = (double)B[j];
                        } else {
                            res = ((double)A[i-1]+(double)B[j])/2;
                        }
                        break;
                    } else {
                        end = end - 1;
                    }
                } else {
                    if(A[i-1] <= B[j]) {
                        if((m+n)%2 == 1) {
                            res = (double)B[j];
                        } else {
                            res = ((double)Math.max(A[i-1], B[j-1])+(double)B[j])/2;
                        }
                        break;
                    } else {
                        end = end - 1;
                    }
                }
            }
        }
        return res;
    }
}


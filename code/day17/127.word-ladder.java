import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (23.84%)
 * Likes:    1431
 * Dislikes: 798
 * Total Accepted:    259.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.remove(beginWord);
        int target = -1;
        for(int i = 0; i < wordList.size(); i++) {
            if(wordList.get(i).equals(endWord)) {
                target = i;
                break;
            }
        }
        if(target == -1) {
            return 0;
        }
        List<List<Integer>> transform = new ArrayList<>();
        for(int i = 0; i < wordList.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < wordList.size(); j++) {
                if(i == j) {
                    continue;
                }
                if(oneLetterDiff(wordList.get(i), wordList.get(j))) {
                    temp.add(j);
                }
            }
            transform.add(temp);
        }
        int res = 0;
        for(int i = 0; i < wordList.size(); i++) {
            if(oneLetterDiff(wordList.get(i), beginWord)) {
                int temp = pathLen(transform, i, target);
                if(temp != -1) {
                    if(res == 0) {
                        res = temp + 1;
                    } else {
                        res = Math.min(res, temp+1);
                    }
                    
                }
            }
        }
        return res;
    }

    public int pathLen(List<List<Integer>> transform, int begin, int target) {
        int path = 1;
        if(begin != target) {
            boolean[] visit = new boolean[transform.size()];
            visit[begin] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.addAll(transform.get(begin));
            int count = transform.get(begin).size();
            boolean flag = true;
            while(count > 0 && flag) {
                path++;
                int temp = count;
                count = 0;
                while(temp > 0) {
                    int index = queue.remove();
                    temp--;
                    if(index == target) {
                        flag = false;
                        break;
                    }
                    if(!visit[index]) {
                        visit[index] = true;
                        List<Integer> l = transform.get(index);
                        for(int i = 0; i < l.size(); i++) {
                            if(!visit[l.get(i)]) {
                                queue.add(l.get(i));
                                count++;
                            }
                        }
                    }
                }
            }
            if(flag == true) {
                path = -1;
            }
        }
        return path;
    }

    public boolean oneLetterDiff(String str1, String str2) {
        int count = 0;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        if(count == 1) {
            return true;
        }
        return false;
    }
}


/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (31.12%)
 * Likes:    1727
 * Dislikes: 84
 * Total Accepted:    280.6K
 * Total Submissions: 898.9K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = true;
                if(exist(board, visited, word, 0, i, j)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, boolean[][] visited, String word, int index, int row, int col) {
        if(board[row][col] != word.charAt(index)) {
            return false;
        } else {
            boolean res = false;
            if(index == word.length()-1) {
                res = true;
            }
            if(!res && row > 0 && !visited[row-1][col]) {
                visited[row-1][col] = true;
                res = exist(board, visited, word, index+1, row-1, col);
                visited[row-1][col] = false;
            }
            if(!res && row < board.length-1 && !visited[row+1][col]) {
                visited[row+1][col] = true;
                res = exist(board, visited, word, index+1, row+1, col);
                visited[row+1][col] = false;
            }
            if(!res && col > 0 && !visited[row][col-1]) {
                visited[row][col-1] = true;
                res = exist(board, visited, word, index+1, row, col-1);
                visited[row][col-1] = false;
            }
            if(!res && col < board[0].length-1 && !visited[row][col+1]) {
                visited[row][col+1] = true;
                res = exist(board, visited, word, index+1, row, col+1);
                visited[row][col+1] = false;
            }
            return res;
        }
    }
}


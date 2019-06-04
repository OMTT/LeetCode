import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (22.71%)
 * Likes:    748
 * Dislikes: 423
 * Total Accepted:    145.4K
 * Total Submissions: 634.9K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
class Solution {
    public void solve(char[][] board) {
        if(board == null) {
            return;
        }
        int m = board.length;
        if(m == 0) {
            return;
        }
        int n = board[0].length;
        Stack<Point> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O') {
                stack.push(new Point(0, i));
            }
            if(board[m-1][i] == 'O') {
                stack.push(new Point(m-1, i));
            }
        }
        for(int i = 1; i < m-1; i++) {
            if(board[i][0] == 'O') {
                stack.push(new Point(i, 0));
            }
            if(board[i][n-1] == 'O') {
                stack.push(new Point(i, n-1));
            }
        }
        while(!stack.empty()) {
            Point p = stack.pop();
            board[p.x][p.y] = 'A';
            if(p.x-1 >= 0 && board[p.x-1][p.y] == 'O') {
                stack.push(new Point(p.x-1, p.y));
            }
            if(p.x+1 < m && board[p.x+1][p.y] == 'O') {
                stack.push(new Point(p.x+1, p.y));
            }
            if(p.y-1 >= 0 && board[p.x][p.y-1] == 'O') {
                stack.push(new Point(p.x, p.y-1));
            }
            if(p.y+1 < n && board[p.x][p.y+1] == 'O') {
                stack.push(new Point(p.x, p.y+1));
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private class Point {
        int x;
        int y;
        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}


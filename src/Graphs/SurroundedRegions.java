package Graphs;
/*
https://leetcode.com/problems/surrounded-regions/
*/


public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2) {
            return;
        }
        for (var i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for (var i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[board.length-1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }

        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    public void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'O') {
            board[x][y] = '*';
        }

        if (y + 1 < board[0].length - 1 && board[x][y+1] == 'O'){
            dfs(board, x, y + 1);
        }
        if (x + 1 < board.length && board[x+1][y] == 'O') {
            dfs(board, x + 1, y);
        }
        if (y - 1 > 0 && board[x][y-1] == 'O') {
            dfs(board, x, y - 1);
        }
        if (x-1 > 0 && board[x-1][y] == 'O') {
            dfs(board, x - 1, y);
        }
    }
}

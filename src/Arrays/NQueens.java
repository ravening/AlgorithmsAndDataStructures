package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
 */
public class NQueens {

    int N;
    int[][] board;

    NQueens(int n) {
        this.N = n;
        this.board = new int[N][N];
        for (var arr : board) {
            Arrays.fill(arr, 0);
        }
    }

    private boolean isSafe(int row, int col) {
        for (var i = col-1; i >= 0; i--) {
            if (board[row][i] == 1)
                return false;
        }

        for (int i = row,j = col; i >=0 && j >= 0; i--,j--) {
            if (board[i][j] == 1)
                return false;
        }

        for (int i = row, j = col; i < N && j >= 0; i++,j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }
    private boolean nQueensUtil(int col) {
        if (col >= this.N)
            return true;

        for (var i = 0; i < this.N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;

                if (nQueensUtil(col + 1)) {
                    return true;
                }

                board[i][col] = 0;
            }
        }

        return false;
    }
    public void nQueens() {
        if (nQueensUtil(0)) {
            printBoard();
        } else {
            System.out.println("No solution");
        }
    }

    private void printBoard() {
        for (var i = 0; i < N; i++) {
            for (var j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens(4);
        nQueens.nQueens();
    }
}

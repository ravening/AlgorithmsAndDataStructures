package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC36 {

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[i].length; j++) {
                char ch = board[i][j];

                if (ch != '.') {
                    if (!set.add(ch + "row" + i) || !set.add(ch + "col" + j) || !set.add(ch + "box" + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LC36 lc36 = new LC36();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(lc36.isValidSudoku(board));  // Output: true
    }
}

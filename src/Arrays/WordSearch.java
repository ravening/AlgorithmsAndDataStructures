package Arrays;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'N','Y','C'},
			{'C','E','A'},
			{'H','S','N'}
		};

		String word = "YES";
		boolean flag = exists(board, word);

		if (!flag) {
			System.out.println("Not found");
		}

		board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		word = "ABCCED";
		flag = exists(board, word);
		System.out.println(flag);
	}

	public static boolean exists(char[][] board, String word) {
		if (board == null || word == null) {
			return false;
		}
		for (int i = 0; i < board.length; i ++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0)) {
					System.out.println("FOUND");
					return true;
				}
			}
		}

		return false;
	}

	public static boolean dfs(char[][] board, String word, int i, int j, int k) {
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(k) || board[i][j] == '#') {
			return false;
		}

		if (k == word.length() - 1) {
			return true;
		}

		char tmp = word.charAt(k);
		board[i][j] = '#';
		if (dfs(board, word, i-1, j, k+1) ||
			dfs(board, word, i, j-1, k+1) ||
			dfs(board,word, i+1, j, k+1) ||
			dfs(board, word, i, j+1, k+1) ) {
			return true;
		}
		board[i][j] = tmp;
		return false;
	}
}

package datastructures.backtracking;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * [
 * ["A","B","C","E"]
 * ["S","F","C","S"],
 * ["A","D","E","E"]
 * ]
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {

        int row = board.length, col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(0, word, board, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int charIndex, String word, char[][] board, int i, int j) {
        if (charIndex >= word.length()) {
            return true;
        }
        if (i < 0 || j < 0
                || i >= board.length
                || j >= board[0].length
                || word.charAt(charIndex) != board[i][j]
        ) {
            return false;
        }

        boolean exist = false;

        if (word.charAt(charIndex) == board[i][j]) {
            board[i][j] += 100;

            exist = dfs(charIndex + 1, word, board, i + 1, j)
                    || dfs(charIndex + 1, word, board, i, j + 1)
                    || dfs(charIndex + 1, word, board, i - 1, j)
                    || dfs(charIndex + 1, word, board, i, j - 1);

            board[i][j] -= 100;
        }

        return exist;
    }

    private static boolean dfs1(int charIndex, String word, char[][] board, int i, int j, int row, int col) {
        if (charIndex >= word.length()) {
            return true;
        }
        if (i < 0 || j < 0
                || i >= row
                || j >= col
//                || visited[row][col] == 1
                || word.charAt(charIndex) != board[i][j]
        ) {
            return false;
        }

        boolean exist = false;

        if (word.charAt(charIndex) == board[i][j]) {
            board[i][j] += 100;

            exist = dfs1(charIndex + 1, word, board, i + 1, j, row, col)
                    || dfs1(charIndex + 1, word, board, i, j + 1, row, col)
                    || dfs1(charIndex + 1, word, board, i - 1, j, row, col)
                    || dfs1(charIndex + 1, word, board, i, j - 1, row, col);

            board[i][j] -= 100;
        }

        return exist;
    }

    public static boolean check(
            char[][] board,
            String word,
            int i,
            int j,
            int m,
            int n,
            int cur
    ) {
        if (cur >= word.length()) return true;
        if (
                i < 0 ||
                        j < 0 ||
                        i >= m ||
                        j >= n ||
                        board[i][j] != word.charAt(cur)
        ) return false;
        boolean exist = false;
        if (board[i][j] == word.charAt(cur)) {
            board[i][j] += 100;
            exist =
                    check(board, word, i + 1, j, m, n, cur + 1) ||
                            check(board, word, i, j + 1, m, n, cur + 1) ||
                            check(board, word, i - 1, j, m, n, cur + 1) ||
                            check(board, word, i, j - 1, m, n, cur + 1);
            board[i][j] -= 100;
        }
        return exist;
    }
}

// 52. N-Queens II
package Hard;

public class Hard_52_N_Queens_II {
    private static int count;
    private static boolean isSafe(boolean[][] board, int r, int c) {
        int row = r;
        // Check upper
        while (r >= 0)
            // If any Queen in the same column, then not safe
            if (board[r--][c]) return false;

        r = row;
        int col = c;
        // Check negative diagonal [top-left]
        while (r >= 0 && c >= 0)
            if (board[r--][c--]) return false;

        r = row;
        c = col;
        // Check positive diagonal [top-right]
        while (r >= 0 && c < board[0].length)
            if (board[r--][c++]) return false;

        return true;
    }
    private static void placeQueens(boolean[][] board, int Q, int row) {
        if (Q == 0) {
            count++;
            return;
        }
        for (int c=0; c<board.length; c++) {
            if (isSafe(board, row, c)) {
                board[row][c] = true;
                placeQueens(board, Q-1, row+1);
                board[row][c] = false;
            }
        }
    }
    public static int totalNQueens(int n) {
        count = 0;
        boolean[][] board = new boolean[n][n];
        placeQueens(board, n, 0);
        return count;
    }
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(1));
    }
}

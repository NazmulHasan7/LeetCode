// 51. N-Queens
package Hard;
import java.util.ArrayList;
import java.util.List;

public class Hard_51_N_Queens {
    private static List<List<String>> answer;
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
    private static void placeQueens(boolean[][] board, int Q, int row, List<String> validBoard) {
        if (Q == 0) {
            for (boolean[] boardRow : board) {
                StringBuilder validRow = new StringBuilder();
                for (int c = 0; c < board.length; c++) {
                    if (boardRow[c])
                        validRow.append('Q');
                    else validRow.append('.');
                }
                validBoard.add(validRow.toString());
            }
            answer.add(new ArrayList<>(validBoard));
            validBoard.clear();
            return;
        }
        for (int c=0; c<board.length; c++) {
            if (isSafe(board, row, c)) {
                board[row][c] = true;
                placeQueens(board, Q-1, row+1, validBoard);
                board[row][c] = false;
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        placeQueens(board, n, 0, new ArrayList<>());
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(1));
    }
}

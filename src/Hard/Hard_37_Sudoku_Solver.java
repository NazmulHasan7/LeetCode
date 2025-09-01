// 37. Sudoku Solver
package Hard;

public class Hard_37_Sudoku_Solver {
    // Backtracking approach
    // O(9^81) -> O(9^(9*9)
    public static void solveSudoku(char[][] board) {
        solve(board);
    }
    private static boolean solve(char[][] board) {
        for (int i=0; i<9; i++) { // O(9)
            for (int j=0; j<9; j++) { // O(9)
                if (board[i][j] == '.') {
                    for (char d='1'; d<='9'; d++) {
                        if (checkValidity(board, i, j, d)) {
                            board[i][j] = d; // do
                            if (solve(board)) return true; // explore
                            board[i][j] = '.'; // undo
                        }
                    }
                    return false;
                }
            }
        } return true; // No dots
    }
    private static boolean checkValidity(char[][] board, int i, int j, char dig) {
        // check in row
        for (int c=0; c<9; c++)
            if (board[i][c] == dig) return false;

        // check in column
        for (int r=0; r<9; r++)
            if (board[r][j] == dig) return false;

        // check sub-boxes
        int startI = i/3 * 3;
        int startJ = j/3 * 3;

        for (int k=0; k<3; k++)
            for (int l=0; l<3; l++)
                if (board[startI+k][startJ+l] == dig)
                    return false;
        return true;
    }
    public static void main(String[] args) {
        solveSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}});
    }
}

// 36. Valid Sudoku
package Medium;
import java.util.Arrays;

public class Medium_36_Valid_Sudoku {
    public static boolean isValidSudoku(char[][] board) {
        // Check in row-direction
        int[] row = new int[9];
        for (int r=0; r<9; r++) {
            Arrays.fill(row, 0);
            for (int c=0; c<9; c++) {
                if (board[r][c] == '.')
                    continue;

                int idx = board[r][c] - '0' - 1;
                if (row[idx] == 1) return false;
                row[idx]++;
            }
        }
        // Check in column-direction
        int[] col = new int[9];
        for (int c=0; c<9; c++) {
            Arrays.fill(col, 0);
            for (int r=0; r<9; r++) {
                if (board[r][c] == '.')
                    continue;

                int idx = board[r][c] - '0' - 1;
                if (col[idx] == 1) return false;
                col[idx]++;
            }
        }
        // Check each boxes
        for (int r=0; r<9; r+=3) {
            for (int c=0; c<9; c+=3) {
                int[] box = new int[9];

                for (int i=r; i<r+3; i++) {
                    for (int j=c; j<c+3; j++) {
                        if (board[i][j] == '.')
                            continue;

                        int idx = board[i][j] - '0' - 1;
                        if (box[idx] == 1) return false;
                        box[idx]++;
                    }
                }
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}


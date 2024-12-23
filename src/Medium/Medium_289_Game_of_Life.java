// 289. Game of Life
package Medium;
import java.util.Arrays;

public class Medium_289_Game_of_Life {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Directions to check all 8 neighbors (top, bottom, left, right, and diagonals)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        // First pass: Modify the board to encode new states without affecting current states
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int liveNeighbors = 0;

                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if (newR >= 0 && newR < m && newC >= 0 && newC < n && Math.abs(board[newR][newC]) == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply the rules:
                // Rule 1 & 3: A live cell with fewer than 2 or more than 3 live neighbors dies
                if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[r][c] = -1; // -1 means the cell is currently alive but will die
                }
                // Rule 4: A dead cell with exactly 3 live neighbors becomes alive
                if (board[r][c] == 0 && liveNeighbors == 3) {
                    board[r][c] = 2; // 2 means the cell is currently dead but will become alive
                }
            }
        }

        // Second pass: Update the board to its final state
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] > 0) {
                    board[r][c] = 1; // Cell is alive
                } else {
                    board[r][c] = 0; // Cell is dead
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(grid);
        System.out.println(Arrays.deepToString(grid));
    }
}

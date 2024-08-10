// 840. Magic Squares In Grid
package Medium;

public class Medium_840_Magic_Squares_In_Grid {
    public static int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int answer = 0;
        for (int r = 0; r + 2 < rows; r++)
            for (int c = 0; c + 2 < cols; c++)
                if (isMagicSquare(r, c, grid))
                    answer++;
        return answer;
    }
    private static boolean isMagicSquare(int row, int col, int[][] grid) {
        boolean[] seen = new boolean[10];
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                int num = grid[r][c];
                if (num < 1 || num > 9 || seen[num])
                    return false;
                seen[num] = true;
            }
        }
        int magicSum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        for (int i = 0; i < 3; i++) {
            if ((grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2]) != magicSum)
                return false;
            if ((grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i]) != magicSum)
                return false;
        }
        if ((grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2]) != magicSum)
            return false;
        if ((grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col]) != magicSum)
            return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(numMagicSquaresInside(new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}}));
        System.out.println(numMagicSquaresInside(new int[][]{{8}}));
    }
}

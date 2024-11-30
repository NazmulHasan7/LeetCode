// 861. Score After Flipping Matrix
package Medium;

public class Medium_861_Score_After_Flipping_Matrix {
    public static int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // To get the highest possible score
        // Flip the entire row if value of first col is 0
        // 1 0 0 0 > 0 1 1 1
        for (int r=0; r<rows; r++) {
            if (grid[r][0] == 0) {
                for (int c=0; c<cols; c++)
                    grid[r][c] = 1 - grid[r][c];
            }
        }

        // Flip the entire column if count of 1 > count of 0
        for (int c=1; c<cols; c++) {
            int count1 = 0, count0 = 0;
            for (int r=0; r<rows; r++) {
                if (grid[r][c] == 1) count1++;
                else count0++;
            }

            if (count1 < count0) { // Flip the column
                for (int r=0; r<rows; r++)
                    grid[r][c] = 1 - grid[r][c];
            }
        }

        int answer = 0;
        for (int r=0; r<rows; r++)
            for (int c=0; c<cols; c++)
                answer += (int) (grid[r][c] * Math.pow(2, cols-c-1));
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
        System.out.println(matrixScore(new int[][]{{0}}));
    }
}

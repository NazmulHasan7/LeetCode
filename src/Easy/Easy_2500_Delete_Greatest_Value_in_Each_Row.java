// 2500. Delete Greatest Value in Each Row
package Easy;
import java.util.Arrays;

public class Easy_2500_Delete_Greatest_Value_in_Each_Row {
    public static int deleteGreatestValue(int[][] grid) {
        int answer = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int totalSum, maxInRow, maxInIteration;
        int r=-1, c=-1;
        do {
            totalSum = maxInIteration = 0;
            for (int i=0; i<rows; i++) {
                maxInRow = 0;
                // System.out.println(Arrays.toString(grid[i]));
                for (int j=0; j<cols; j++) {
                    totalSum += grid[i][j];
                    if (grid[i][j] > maxInRow) {
                        r = i;
                        c = j;
                        maxInRow = grid[i][j];
                    }
                } grid[r][c] = 0;
                maxInIteration = Math.max(maxInRow, maxInIteration);
            } answer += maxInIteration;
            // System.out.println(answer);
        } while (totalSum != 0);
        return answer;
    }
    public static int deleteGreatestValueBetter(int[][] grid) {
        for (int[] gridRow : grid)
            Arrays.sort(gridRow);

        int sum = 0, max;
        for (int col=0; col<grid[0].length; col++) {
            max = 0;
            for (int row=0; row<grid.length; row++) {
                if (grid[row][col] > max) max = grid[row][col];
            } sum += max;
        } return sum;
    }
    public static void main(String[] args) {
        System.out.println(deleteGreatestValue(new int[][] {{1,2,4},{3,3,1}}));
        System.out.println(deleteGreatestValue(new int[][] {{10}}));
        System.out.println(deleteGreatestValueBetter(new int[][] {{1,2,4},{3,3,1}}));
        System.out.println(deleteGreatestValueBetter(new int[][] {{10}}));
    }
}

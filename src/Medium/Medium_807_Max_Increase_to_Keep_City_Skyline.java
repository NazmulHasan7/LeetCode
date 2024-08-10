// 807. Max Increase to Keep City Skyline
package Medium;

public class Medium_807_Max_Increase_to_Keep_City_Skyline {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        // Idea -> Min(Max of row [index], Max of Column [index])
        int n = grid.length;
        int[] maxInRows = new int[n];
        int[] maxInCols = new int[n];

        // Get maximum values for each row and column
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                maxInRows[r] = Math.max(maxInRows[r], grid[r][c]);
                maxInCols[c] = Math.max(maxInCols[c], grid[r][c]);
            }
        }
        int sum = 0;
        for (int r=0; r<n; r++)
            for (int c=0; c<n; c++)
                sum += Math.min(maxInRows[r], maxInCols[c]) - grid[r][c];
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(maxIncreaseKeepingSkyline(
                new int[][] {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }
}

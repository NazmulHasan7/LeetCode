// 2428. Maximum Sum of an Hourglass
package Medium;

public class Medium_2428_Maximum_Sum_of_an_Hourglass {
    public static int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for (int r=0; r<m-2; r++) {
            for (int c=0; c<n-2; c++) {
                int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2]
                        + grid[r+1][c+1] +
                        grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2];
                max = Math.max(max, sum);
            }
        } return max;
    }
    public static void main(String[] args) {
        System.out.println(maxSum(new int[][]{{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}}));
        System.out.println(maxSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}

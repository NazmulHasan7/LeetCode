// 3459. Length of Longest V-Shaped Diagonal Segment
package Hard;

public class Hard_3459_Length_of_Longest_V_Shaped_Diagonal_Segment {
    private static final int[][] DIRECTIONS = new int[][] {
            {1, 1}, {1, -1}, {-1, -1}, {-1, 1}
    }; // to maintain the clockwise rotation direction
    private static int rows;
    private static int cols;

    private static int[][][][] dp;

    public static int lenOfVDiagonal(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int answer = 0;
        dp = new int[rows][cols][4][2];

        for (int r=0; r<rows; r++)
            for (int c=0; c<cols; c++)
                for (int d=0; d<4; d++)
                    Arrays.fill(dp[r][c][d], -1);

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (grid[r][c] == 1) {
                    for (int d=0; d<4; d++) {
                        answer = Math.max(answer, solve(grid, r, c, d, 1, 2)+1);
                    }
                }
            }
        } return answer;
    }
    private static int solve(int[][] grid, int r, int c, int dir, int hasTurn, int target) {
        int nr = r + DIRECTIONS[dir][0];
        int nc = c + DIRECTIONS[dir][1];
        // check boundary & validity for next move
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != target)
            return 0;

        if (dp[nr][nc][dir][hasTurn] != -1)
            return dp[nr][nc][dir][hasTurn];

        // do not take turn just go in the direction
        int doNotTakeTurn = 1 + solve(grid, nr, nc, dir, hasTurn, 2-target);
        int takeTurn = 0;
        if (hasTurn == 1) // take a 90-degree turn
            takeTurn = 1 + solve(grid, nr, nc, (dir+1) % 4, 0, 2-target);

        return dp[nr][nc][dir][hasTurn] = Math.max(doNotTakeTurn, takeTurn);
    }
    public static void main(String[] args) {
        System.out.println(lenOfVDiagonal(new int[][]{{2,2,1,2,2},{2,0,2,2,0},{2,0,1,1,0},{1,0,2,2,2},{2,0,0,2,2}}));
        System.out.println(lenOfVDiagonal(new int[][]{{2,2,2,2,2},{2,0,2,2,0},{2,0,1,1,0},{1,0,2,2,2},{2,0,0,2,2}}));
        System.out.println(lenOfVDiagonal(new int[][]{{1,2,2,2,2},{2,2,2,2,0},{2,0,0,0,0},{0,0,2,2,2},{2,0,0,2,0}}));
        System.out.println(lenOfVDiagonal(new int[][]{{1}}));
    }
}

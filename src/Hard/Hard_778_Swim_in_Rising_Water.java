// 778. Swim in Rising Water
package Hard;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Hard_778_Swim_in_Rising_Water {
    private static int rows;
    private static int cols;
    private static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    private static boolean[][] visited;
    private static int[][] memo;
    private static int answer;

    // DP + Memoization Approach
    public static int swimInWater(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        answer = Integer.MAX_VALUE;

        visited = new boolean[rows][cols];
        memo = new int[rows][cols];
        for (int[] m : memo) Arrays.fill(m, -1);

        solve(grid, 0, 0, grid[0][0]);
        return answer;
    }

    private static void solve(int[][] grid, int r, int c, int time) {
        // check if we have already visited the cell with a lesser time
        if (memo[r][c] != -1 && time >= memo[r][c]) return;

        memo[r][c] = time; // stores the best time we have found so far to reach the cell

        if (r == rows-1 && c == cols-1) {
            answer = Math.min(answer, time);
            return; // reached the destination
        }
        visited[r][c] = true;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                int nextTime = Math.max(grid[nr][nc], time);
                if (nextTime < answer)
                    solve(grid, nr, nc, nextTime);
            }
        }
        visited[r][c] = false; // undo the changes
    }

    // Dijkstra's Shortest Path Algorithm approach
    public static int swimInWaterBetter(int[][] grid) {
        int rn = grid.length;
        int cn = grid[0].length;
        boolean[][] visited = new boolean[rn][cn];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        minHeap.add(new int[]{grid[0][0], 0, 0}); // elevation, row, column

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int time = current[0];
            int r = current[1];
            int c = current[2];

            // reached the destination
            if (r == rn-1 && c == cn-1) return time;
            if (visited[r][c]) continue; // already visited

            visited[r][c] = true;
            for (int[] dir : directions) {
                int r_ = r + dir[0];
                int c_ = c + dir[1];
                if (r_ >= 0 && r_ < rn && c_ >= 0 && c_ < cn && !visited[r_][c_]) {
                    int updatedTime = Math.max(time, grid[r_][c_]);
                    minHeap.add(new int[]{updatedTime, r_, c_});
                }
            }
        } return -1;
    }

    public static void main(String[] args) {
        System.out.println(swimInWaterBetter(new int[][]{{0,2},{1,3}}));
        System.out.println(swimInWaterBetter(new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}}));
    }
}

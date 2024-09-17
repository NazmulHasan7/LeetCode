// 1631. Path With Minimum Effort
package Medium;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Medium_1631_Path_With_Minimum_Effort {
    public static int minimumEffortPath(int[][] heights) {
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}}; // top, right, left, down
        int m = heights.length;
        int n = heights[0].length;

        int[][] result = new int[m][n];
        for (int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);
        result[0][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        minHeap.add(new int[]{0, 0, 0}); // x, y, cost -> effort to from a coordinate to the next coordinate

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int x = top[0];
            int y = top[1];
            int effort = top[2];

            if (x == m-1 && y == n-1) return effort;

            if (effort <= result[x][y]) {
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        // effort is the maximum absolute difference
                        int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[newX][newY]));
                        if (newEffort < result[newX][newY]) {
                            result[newX][newY] = newEffort;
                            minHeap.add(new int[]{newX, newY, newEffort});
                        }
                    }
                }
            }
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}}));
        System.out.println(minimumEffortPath(new int[][]{{1,2,3},{3,8,4},{5,3,5}}));
        System.out.println(minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}}));
    }
}

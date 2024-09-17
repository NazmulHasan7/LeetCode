// 1091. Shortest Path in Binary Matrix
package Medium;
import java.util.ArrayDeque;

public class Medium_1091_Shortest_Path_in_Binary_Matrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};
        int n = grid.length;
        // source to destination cannot be reached
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        // BFS Approach
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0,0,1}); // source, destination, weight
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.remove();
            int r = node[0];
            int c = node[1];
            int w = node[2];

            if (r == n-1 && c == n-1) return w;
            for (int[] d : directions) {
                int newR = r + d[0], newC = c + d[1];
                if (newR >= 0 && newC >= 0 && newR < n && newC < n && grid[newR][newC] == 0) {
                    grid[newR][newC] = 1; // Marking the cell as visited
                    queue.add(new int[]{newR, newC, w+1});
                }
            }
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
    }
}

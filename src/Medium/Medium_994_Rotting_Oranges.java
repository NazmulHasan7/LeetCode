// 994. Rotting Oranges
package Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_994_Rotting_Oranges {
    public static int orangesRotting(int[][] grid) {
        // DFS approach fails as the neighboring oranges get rotten simultaneously
        // TC -> O(V+E)=O(m×n+4×m×n)=O(m×n) SC -> O(m*n)
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 1) freshCount++;
                else if (grid[r][c] == 2) queue.add(new int[]{r,c});
            }
        }
        // Every minute, any fresh orange that is 4-directionally
        // adjacent to a rotten orange becomes rotten
        int time = 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            while (size > 0) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                // If the adjacent cells are in bound and fresh, add them to the queue
                // and mark them as rotten
                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if (newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        queue.add(new int[]{newR, newC});
                        freshCount--;
                    }
                } size--;
            } time++;
        }
        return freshCount == 0 ? time : -1;
    }
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println(orangesRotting(new int[][]{{0,2}}));
    }
}

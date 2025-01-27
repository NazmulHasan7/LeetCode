// 1765. Map of Highest Peak
package Medium;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_1765_Map_of_Highest_Peak {
    // Multi-source BFS : TC & SC O(m*n)
    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] answer = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Build initial answer array, -1 for unmarked cells, 0 for water
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i,j});
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = -1;
                }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];
                int height = answer[r][c];

                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if (newR >= 0 && newR < m && newC >= 0 && newC < n && answer[newR][newC] == -1) {
                        answer[newR][newC] = height + 1;
                        queue.add(new int[]{newR, newC});
                    }
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(highestPeak(new int[][]{{0,1},{0,0}})));
        System.out.println(Arrays.deepToString(highestPeak(new int[][]{{0,0,1},{1,0,0},{0,0,0}})));
    }
}

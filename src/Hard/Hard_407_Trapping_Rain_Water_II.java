// 407. Trapping Rain Water II
package Hard;
import java.util.PriorityQueue;

public class Hard_407_Trapping_Rain_Water_II {
    public static int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;

        // To keep track of the visited cells
        boolean[][] visited = new boolean[rows][cols];
        // A min heap to maintain a sorted order of boundary cells
        // elevation, row, column
        PriorityQueue<int[]> boundary = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        // The edge cells cannot contain any water as the water spills off
        // Left and right boundary
        for (int i=0; i<rows; i++) {
            visited[i][0] = true;
            visited[i][cols-1] = true;
            boundary.add(new int[]{heightMap[i][0], i, 0});
            boundary.add(new int[]{heightMap[i][cols-1], i, cols-1});
        }
        // Top and bottom boundary
        for (int i=0; i<cols; i++) {
            visited[0][i] = true;
            visited[rows-1][i] = true;
            boundary.add(new int[]{heightMap[0][i], 0, i});
            boundary.add(new int[]{heightMap[rows-1][i], rows-1, i});
        }

        // Directions
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        int trappedWater = 0;
        while (!boundary.isEmpty()) {
            int[] min = boundary.poll();
            int minBoundaryHeight = min[0];
            int r = min[1];
            int c = min[2];

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && !visited[newR][newC]) {
                    int neighbourHeight = heightMap[newR][newC];
                    // Check if water can be trapped
                    if (neighbourHeight < minBoundaryHeight)
                        trappedWater += (minBoundaryHeight - neighbourHeight);

                    // Push the neighbor into the boundary with updated height (to prevent water leakage)
                    boundary.add(new int[]{Math.max(neighbourHeight, minBoundaryHeight), newR, newC});
                    visited[newR][newC] = true;
                }
            }
        } return trappedWater;
    }
    public static void main(String[] args) {
        System.out.println(trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
        System.out.println(trapRainWater(new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}}));
    }
}

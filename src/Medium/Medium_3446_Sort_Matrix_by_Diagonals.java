// 3446. Sort Matrix by Diagonals
package Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Medium_3446_Sort_Matrix_by_Diagonals {
    // Same as problem - 1329. Sort the Matrix Diagonally
    public static int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, PriorityQueue<Integer>> mapMinHeap = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> mapMaxHeap = new HashMap<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int key = i-j;
                if (key < 0) {
                    mapMinHeap.computeIfAbsent(key,
                            k -> new PriorityQueue<>()
                    ).add(grid[i][j]);
                } else {
                    mapMaxHeap.computeIfAbsent(key,
                            k -> new PriorityQueue<>((a,b) -> Integer.compare(b,a))
                    ).add(grid[i][j]);
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int key = i-j;
                if (key < 0) grid[i][j] = mapMinHeap.get(key).poll();
                else grid[i][j] = mapMaxHeap.get(key).poll();
            }
        }
        return grid;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(sortMatrix(new int[][]{
                {1,7,3},{9,8,2},{4,5,6}})));
        System.out.println(Arrays.deepToString(sortMatrix(new int[][]{{0,1},{1,2}})));
    }
}

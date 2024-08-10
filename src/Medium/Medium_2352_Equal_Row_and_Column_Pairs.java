// 2352. Equal Row and Column Pairs
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Medium_2352_Equal_Row_and_Column_Pairs {
    public static int equalPairs(int[][] grid) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();

        for (int r=0; r<grid.length; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c=0; c<grid[0].length; c++)
                row.add(grid[r][c]);
            map.put(row, map.getOrDefault(row, 0) + 1);
        }
        int count = 0;
        for (int c=0; c<grid[0].length; c++) {
            List<Integer> col = new ArrayList<>();
            for (int r=0; r<grid.length; r++)
                col.add(grid[r][c]);
            if (map.containsKey(col)) count += map.get(col);
        } return count;
    }
    public static int equalPairsBetter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] transpose = new int[rows][cols];

        // Transpose the matrix
        for (int r=0; r<rows; r++)
            for (int c=0; c<cols; c++)
                transpose[c][r] = grid[r][c];

        // Compare the Arrays
        int count = 0;
        for (int[] row : grid)
            for (int[] col : transpose)
                if (Arrays.equals(row, col))
                    count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][] {{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println(equalPairs(new int[][] {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
        System.out.println(equalPairsBetter(new int[][] {{3,2,1},{1,7,6},{2,7,7}}));
    }
}

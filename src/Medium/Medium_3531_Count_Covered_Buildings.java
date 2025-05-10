// 3531. Count Covered Buildings
package Medium;
import java.util.HashMap;

public class Medium_3531_Count_Covered_Buildings {
    public static int countCoveredBuildings(int n, int[][] buildings) {
        // keep track of the first and last building of the row
        HashMap<Integer, int[]> rowMap = new HashMap<>();
        // keep track of the first and last building of the column
        HashMap<Integer, int[]> colMap = new HashMap<>();

        for (int[] building : buildings) {
            int r = building[0];
            int c = building[1];

            rowMap.putIfAbsent(r, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            rowMap.get(r)[0] = Math.min(rowMap.get(r)[0], c);
            rowMap.get(r)[1] = Math.max(rowMap.get(r)[1], c);

            colMap.putIfAbsent(c, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            colMap.get(c)[0] = Math.min(colMap.get(c)[0], r);
            colMap.get(c)[1] = Math.max(colMap.get(c)[1], r);
        }

        int count = 0;
        for (int[] building : buildings) {
            int r = building[0];
            int c = building[1];

            int[] rowEdgeBuildings = rowMap.get(r);
            int[] colEdgeBuildings = colMap.get(c);

            // count covered buildings
            if (r > colEdgeBuildings[0] && c > rowEdgeBuildings[0] &&
                    r < colEdgeBuildings[1] && c < rowEdgeBuildings[1])
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countCoveredBuildings(3, new int[][]{{1,2},{2,2},{3,2},{2,1},{2,3}}));
        System.out.println(countCoveredBuildings(3, new int[][]{{1,1},{1,2},{2,1},{2,2}}));
    }
}

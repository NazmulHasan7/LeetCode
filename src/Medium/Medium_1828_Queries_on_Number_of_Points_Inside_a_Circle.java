// 1828. Queries on Number of Points Inside a Circle
package Medium;
import java.util.Arrays;

public class Medium_1828_Queries_on_Number_of_Points_Inside_a_Circle {
    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            int count = 0;
            int cx = queries[i][0];
            int cy = queries[i][1];
            int cr = queries[i][2];
            for (int j=0; j<points.length; j++) {
                int x = points[j][0], y = points[j][1];
                // Calculating euclidean distance
                if ((x-cx)*(x-cx) + (y-cy)*(y-cy) <= cr*cr)
                    count++;
            } result[i] = count;
        } return result;
    }
    public static void main(String[] args) {
        int[][] points  = {{1,3},{3,3},{5,3},{2,2}};
        int[][] queries = {{2,3,1},{4,3,1},{1,1,2}};
        System.out.println(Arrays.toString(countPoints(points, queries)));
    }
}

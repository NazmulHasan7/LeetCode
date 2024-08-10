// 2285. Maximum Total Importance of Roads
package Medium;
import java.util.Arrays;

public class Medium_2285_Maximum_Total_Importance_of_Roads {
    public static long maximumImportance(int n, int[][] roads) {
        // Highest Degree should have the highest value
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);

        int value = 1;
        long sum = 0;
        for (int d : degree) {
            sum += ((long) d * value);
            value++;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
        System.out.println(maximumImportance(5, new int[][]{{0,3},{2,4},{1,3}}));
    }
}

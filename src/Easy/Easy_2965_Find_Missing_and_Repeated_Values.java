// 2965. Find Missing and Repeated Values
package Easy;
import java.util.Arrays;
import java.util.HashSet;

public class Easy_2965_Find_Missing_and_Repeated_Values {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int repeated = 0, missing = 0, sum = 0;
        for (int[] gr : grid) {
            for (int num : gr) {
                sum += num;
                if (!set.add(num))
                    repeated = num;
            }
        }
        int n = grid.length * grid.length;
        missing = (n * (n+1) / 2) + repeated - sum;
        return new int[] {repeated, missing};
    }
    public static int[] findMissingAndRepeatedValuesBetter(int[][] grid) {
        int n = grid.length;
        int[] res = new int[2];
        int[] arr = new int[n * n + 1];

        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                arr[grid[i][j]]++;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0) res[1] = i;
            else if (arr[i] > 1) res[0] = i;
        } return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(
                new int[][] {{1,3}, {2,2}})));
        System.out.println(Arrays.toString(findMissingAndRepeatedValuesBetter(
                new int[][] {{9,1,7}, {8,9,2}, {3,4,6}})));
        System.out.println(Arrays.toString(findMissingAndRepeatedValuesBetter(
                new int[][] {{1,3}, {2,2}})));
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(
                new int[][] {{9,1,7}, {8,9,2}, {3,4,6}})));
    }
}

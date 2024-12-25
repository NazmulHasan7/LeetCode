// 1409. Queries on a Permutation With Key
package Medium;
import java.util.Arrays;

public class Medium_1409_Queries_on_a_Permutation_With_Key {
    private static int findIndex(int[] arr, int val) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == val) {
                shiftValues(arr, i, val);
                return i;
            }
        } return 0;
    }
    private static void shiftValues(int[] arr, int idx, int target) {
        for (int i=idx; i>0; i--)
            arr[i] = arr[i-1];
        arr[0] = target;
    }
    public static int[] processQueries(int[] queries, int m) {
        int[] arr = new int[m];

        for (int i=0; i<m; i++)
            arr[i] = i+1;

        for (int i=0; i<queries.length; i++)
            queries[i] = findIndex(arr, queries[i]);

        return queries;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(processQueries(new int[]{3,1,2,1},5)));
        System.out.println(Arrays.toString(processQueries(new int[]{4,1,2,2},4)));
    }
}

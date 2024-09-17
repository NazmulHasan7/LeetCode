// 1310. XOR Queries of a Subarray
package Medium;
import java.util.Arrays;

public class Medium_1310_XOR_Queries_of_a_Subarray {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        // Cumulative sum approach
        int n = arr.length;
        int[] cumXor = new int[n]; // SC -> O(n)
        cumXor[0] = arr[0];
        for (int i=1; i<n; i++)
            cumXor[i] = cumXor[i-1] ^ arr[i];
        // cumXor[i] = arr[0] ^ arr[1] ^ arr[2] ......... ^ arr[i]
        // cumXor[i] = a1^a2^a3......^ai

        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            // for query {2,4} cumXor[l-1] = a1^a2, cumXor[r] = a1^a2^a3^a4^a5
            // cumXor[l-1] ^ cumXor[r] = a3 ^ a4 ^ a5 since x ^ x = 0
            answer[idx++] = l == 0 ? cumXor[r] : cumXor[l-1] ^ cumXor[r];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries(
                new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}})));
        System.out.println(Arrays.toString(xorQueries(
                new int[]{4,8,2,10}, new int[][]{{2,3},{1,3},{0,0},{0,3}})));
    }
}

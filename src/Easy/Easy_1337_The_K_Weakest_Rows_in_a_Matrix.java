// 1337 The K Weakest Rows in a Matrix
package Easy;
import java.util.Arrays;
import java.util.Comparator;

public class Easy_1337_The_K_Weakest_Rows_in_a_Matrix {
    static class Pair {
        int index;
        int soldierCount;
        public Pair(int index, int soldierCount) {
            this.index = index;
            this.soldierCount = soldierCount;
        }
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        Pair[] pairs = new Pair[mat.length];
        int idx = 0;

        for (int i=0; i<mat.length; i++) {
            int count = 0;
            for (int num : mat[i])
                if (num == 1) count++;
            pairs[idx++] = new Pair(i, count);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.soldierCount - p2.soldierCount;
            }
        });
        int[] result = new int[k];
        for (int i=0; i<k; i++)
            result[i] = pairs[i].index;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(new int[][] {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}}, 3
        )));
    }
}

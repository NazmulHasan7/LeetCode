// 3572. Maximize Y‑Sum by Picking a Triplet of Distinct X‑Values
package Medium;
import java.util.HashMap;

public class Medium_3572_Maximize_Y_Sum_by_Picking_a_Triplet_of_Distinct_X_Values {
    public static int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = x.length;

        for (int i=0; i<n; i++)
            map.put(x[i], Math.max(y[i], map.getOrDefault(x[i],0)));

        if (map.size() < 3) return -1; // there should be at least 3 unique values for x

        int a = 0, b = 0, c = 0;
        for (int num : map.values()) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (num > b) {
                c = b;
                b = num;
            } else if (num > c) {
                c = num;
            }
        } return a + b + c;
    }
    public static void main(String[] args) {
        System.out.println(maxSumDistinctTriplet(new int[]{1,2,1,3,2}, new int[]{5,3,4,6,2}));
        System.out.println(maxSumDistinctTriplet(new int[]{1,2,1,2}, new int[]{4,5,6,7}));
    }
}

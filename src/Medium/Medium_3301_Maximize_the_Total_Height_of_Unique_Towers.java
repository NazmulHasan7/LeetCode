// 3301. Maximize the Total Height of Unique Towers
package Medium;
import java.util.Arrays;

public class Medium_3301_Maximize_the_Total_Height_of_Unique_Towers {
    public static long maximumTotalSum(int[] maximumHeight) {
        int n = maximumHeight.length;
        Arrays.sort(maximumHeight);
        if (maximumHeight[n-1] < n) return -1;

        int nextTower = maximumHeight[n-1];
        long total = nextTower;

        for (int i=n-2; i>=0; i--) {
            if (maximumHeight[i] >= nextTower)
                maximumHeight[i] = Math.min(nextTower-1, maximumHeight[i]);

            if (maximumHeight[i] <= 0) return -1;
            nextTower = maximumHeight[i];
            total += nextTower;
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(maximumTotalSum(new int[]{2,3,4,3}));
        System.out.println(maximumTotalSum(new int[]{15,10}));
        System.out.println(maximumTotalSum(new int[]{2,2,1}));
        System.out.println(maximumTotalSum(new int[]{6,6,6,3,7,2,6,5}));
    }
}

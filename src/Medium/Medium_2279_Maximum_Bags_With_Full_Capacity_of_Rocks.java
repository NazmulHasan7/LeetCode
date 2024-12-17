// 2279. Maximum Bags With Full Capacity of Rocks
package Medium;
import java.util.Arrays;

public class Medium_2279_Maximum_Bags_With_Full_Capacity_of_Rocks {
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] space = new int[n];

        for (int i=0; i<n; i++)
            space[i] = capacity[i] - rocks[i];

        Arrays.sort(space);

        int count = 0;
        for (int i=0; i<n; i++) {
            if (space[i] == 0) {
                count++; // these bags are already full
            } else {
                if (additionalRocks >= space[i]) {
                    additionalRocks -= space[i];
                    count++;
                } else {
                    return count;
                }
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(maximumBags(new int[]{2,3,4,5}, new int[]{1,2,4,4},2));
        System.out.println(maximumBags(new int[]{10,2,2}, new int[]{2,2,0},100));
    }
}

// 1921. Eliminate Maximum Number of Monsters
package Medium;
import java.util.Arrays;

public class Medium_1921_Eliminate_Maximum_Number_of_Monsters {
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrival = new int[n];

        for (int i=0; i<n; i++)
            arrival[i] = (dist[i]-1)/speed[i];

        Arrays.sort(arrival);
        for (int i=0; i<n; i++)
            if (arrival[i] < i) return i;

        return n;
    }
    public static void main(String[] args) {
        System.out.println(eliminateMaximum(new int[]{1,3,4}, new int[]{1,1,1}));
        System.out.println(eliminateMaximum(new int[]{1,1,2,3}, new int[]{1,1,1,1}));
        System.out.println(eliminateMaximum(new int[]{3,2,4}, new int[]{5,3,2}));
    }
}

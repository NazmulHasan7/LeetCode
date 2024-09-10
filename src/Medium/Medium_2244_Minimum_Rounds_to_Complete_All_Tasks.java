// 2244. Minimum Rounds to Complete All Tasks
package Medium;
import java.util.HashMap;

public class Medium_2244_Minimum_Rounds_to_Complete_All_Tasks {
    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : tasks)
            map.put(n, map.getOrDefault(n,0)+1);

        int count = 0;
        for (int freq : map.values()) {
            // Edge case : the array cannot be made empty
            if (freq == 1) return -1;
            count += freq / 3;
            if (freq % 3 != 0)
                count++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
        System.out.println(minimumRounds(new int[]{2,3,3}));
    }
}

// 781. Rabbits in Forest
package Medium;
import java.util.HashMap;
import java.util.Map;

public class Medium_781_Rabbits_in_Forest {
    public static int numRabbits(int[] answers) {
        int[] map = new int[1001];
        int rabbitCount = 0;

        for (int a : answers) {
            if (a == 0) // no other rabbit has the same color
                rabbitCount++;
            else map[a]++;
        }

        for (int colorGroup=0; colorGroup<=1000; colorGroup++) {
            if (map[colorGroup] > 0) {
                int size = map[colorGroup];
                if (size == colorGroup+1) {
                    // 2 -> 3 => 3 rabbits saying there are 2 other rabbits with the same color
                    rabbitCount += (colorGroup+1);
                } else {
                    // [2,2,2,2,2] => {2, 5} each group should be of 3 rabbits
                    // get the count of groups => total / expected group size
                    // then minimum rabbit count for these groups = # groups * expected group size
                    rabbitCount += (Math.ceilDiv(size, colorGroup+1) * (colorGroup+1));
                }
            }
        } return rabbitCount;
    }

    public static int numRabbitsOpt(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rabbitCount = 0;

        for (int a : answers) {
            if (a == 0) // no other rabbit has the same color
                rabbitCount++;
            else map.put(a, map.getOrDefault(a, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int colorGroup = entry.getKey();
            int size = entry.getValue();

            if (size == colorGroup+1) {
                // 2 -> 3 => 3 rabbits saying there are 2 other rabbits with the same color
                rabbitCount += (colorGroup+1);
            } else {
                // [2,2,2,2,2] => {2, 5} each group should be of 3 rabbits
                // get the count of groups => total / expected group size
                // then minimum rabbit count for these groups = # groups * expected group size
                rabbitCount += (Math.ceilDiv(size, colorGroup+1) * (colorGroup+1));
            }
        } return rabbitCount;
    }
    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1,1,2}));
        System.out.println(numRabbits(new int[]{10,10,10}));
    }
}

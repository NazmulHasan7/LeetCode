// 475. Heaters
package Medium;
import java.util.Arrays;

public class Medium_475_Heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int start = 0;
        int end = Math.max(
                Math.abs(houses[0] - heaters[heaters.length-1]),
                Math.abs(heaters[0] - houses[houses.length-1])
        );

        while (start < end) {
            int radius = start + (end - start) / 2;
            if (canWarmAllHouses(radius, houses, heaters))
                end = radius;
            else start = radius + 1;
        }
        return end;
    }
    // O(houses.length + heaters.length)
    private static boolean canWarmAllHouses(int rad, int[] houses, int[] heaters) {
        int hi = 0;
        for (int house : houses) {
            while (hi < heaters.length && Math.abs(house - heaters[hi]) > rad)
                hi++;
            if (hi >= heaters.length) // ran out of heaters
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
         System.out.println(findRadius(new int[]{1,2,3}, new int[]{2}));
         System.out.println(findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
         System.out.println(findRadius(new int[]{1,5}, new int[]{2}));
         System.out.println(findRadius(new int[]{1,5}, new int[]{10}));
    }
}

// 2501. Longest Square Streak in an Array
package Medium;
import java.util.HashSet;
import java.util.Set;

public class Medium_2501_Longest_Square_Streak_in_an_Array {
    public static int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int n : nums) set.add((long) n);

        int maxLen = 0;
        for (int n : nums) {
            int length = 1;
            long x = n;
            while (set.contains(x * x)) {
                length++;
                x *= x;
            } maxLen = Math.max(maxLen, length);
        } return maxLen > 1 ? maxLen : -1;
    }
    public static int longestSquareStreakBetter(int[] nums) {
        int max = 100000;
        boolean[] arr = new boolean[max + 1];
        for (int n : nums) arr[n] = true;

        int maxLen = 0;
        for (long n : nums) {
            int length = 0;
            while (n < max && arr[(int)n]) {
                n *= n;
                length++;
            } maxLen = Math.max(maxLen, length);
        } return maxLen > 1 ? maxLen : -1;
    }
    public static void main(String[] args) {
        System.out.println(longestSquareStreak(new int[]{4,3,6,16,8,2}));
        System.out.println(longestSquareStreak(new int[]{2,3,5,6,7}));
    }
}

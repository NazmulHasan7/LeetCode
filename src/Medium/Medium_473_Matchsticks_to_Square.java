// 473. Matchsticks to Square
package Medium;
import java.util.Arrays;

public class Medium_473_Matchsticks_to_Square {
    static int[] sides;
    public static boolean makesquare(int[] matchsticks) {
        sides = new int[4];
        int sum = 0;
        for (int match : matchsticks)
            sum += match;
        if (sum % 4 != 0) return false;

        Arrays.sort(matchsticks);
        // The max value should be a side
        return backtrack(matchsticks, matchsticks.length-1, sum / 4);
    }
    private static boolean backtrack(int[] matchsticks, int index, int target) {
        if (sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target)
            return true;

        if (sides[0] > target || sides[1] > target || sides[2] > target || sides[3] > target)
            return false;

        for (int i = 0; i < 4; i++) {
            sides[i] += matchsticks[index];
            if (backtrack(matchsticks, index-1, target)) return true;
            sides[i] -= matchsticks[index];
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{1,1,2,2,2}));
        System.out.println(makesquare(new int[]{3,3,3,3,4}));
    }
}

// 2028. Find Missing Observations
package Medium;
import java.util.Arrays;

public class Medium_2028_Find_Missing_Observations {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int r : rolls) sum += r;
        int m = rolls.length;

        // mean = (sum + gap) / (m + n)
        // => (sum + gap) = mean * (m + n)
        // => gap = mean * (m + n) - sum

        int gap = mean * (m + n) - sum;
        if (gap < n || gap > 6 * n) return new int[]{};

        int value = gap / n;
        int remainder = gap % n;
        int[] result = new int[n];
        Arrays.fill(result, value);

        int idx = 0;
        while (idx < remainder)
            result[idx++]++;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingRolls(new int[]{3,2,4,3}, 4, 2)));
        System.out.println(Arrays.toString(missingRolls(new int[]{1,5,6}, 3, 4)));
        System.out.println(Arrays.toString(missingRolls(new int[]{1,2,3,4}, 6, 4)));
    }
}

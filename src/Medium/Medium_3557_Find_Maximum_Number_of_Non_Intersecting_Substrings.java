// 3557. Find Maximum Number of Non Intersecting Substrings
package Medium;
import java.util.Arrays;

public class Medium_3557_Find_Maximum_Number_of_Non_Intersecting_Substrings {
    public static int maxSubstrings(String word) {
        int[] prevAppearance = new int[26];
        Arrays.fill(prevAppearance, -1);
        int currIdx = 0;
        int count = 0;

        // Find the first one that satisfies the condition and check from there again
        for (char c : word.toCharArray()) {
            int x = c-'a';
            if (prevAppearance[x] != -1) {
                int dist = currIdx - prevAppearance[x] + 1;
                if (dist >= 4) {
                    count++; // reset the array
                    Arrays.fill(prevAppearance, -1);
                }
            } else {
                prevAppearance[x] = currIdx;
            } currIdx++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(maxSubstrings("abcdeafdef"));
        System.out.println(maxSubstrings("bcdaaaab"));
    }
}

// 3016. Minimum Number of Pushes to Type Word II
package Medium;
import java.util.Arrays;

public class Medium_3016_Minimum_Number_of_Pushes_to_Type_Word_II {
    public static int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray())
            freq[c-'a']++;

        Arrays.sort(freq);

        int push = 0;
        int currentPushNeeded = 1;
        int counter = 0;

        // Evenly distribute the characters
        for (int i=25; i>=0; i--) {
            if (freq[i] == 0) break;
            push += (currentPushNeeded * freq[i]);
            counter++;

            if (counter == 8) { // 2 to 9
                counter = 0;
                currentPushNeeded++;
            }
        }
        return push;
    }
    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));
        System.out.println(minimumPushes("xyzxyzxyzxyz"));
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}

// 1239. Maximum Length of a Concatenated String with Unique Characters
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
    private static int max;
    public static int maxLength(List<String> arr) {
        max = 0;
        backtrack(arr, new int[26], 0, 0);
        return max;
    }
    private static void backtrack(List<String> arr, int[] freq, int idx, int size) {
        if (idx == arr.size()) {
            max = Math.max(max, size);
            return;
        }
        max = Math.max(max, size);

        char[] crr = arr.get(idx).toCharArray();
        if (!hashDuplicates(crr, freq)) {
            // Pick the current string
            for (char c : crr) freq[c - 'a']++;
            backtrack(arr, freq, idx + 1, size + crr.length);
            // Undo the pick
            for (char c : crr) freq[c - 'a']--;
        }
        // Don't pick the current string
        backtrack(arr, freq, idx + 1, size);
    }

    private static boolean hashDuplicates(char[] crr, int[] freq) {
        int[] tempFreq = Arrays.copyOf(freq, freq.length);
        for (char c : crr) {
            if (tempFreq[c - 'a'] == 1)
                return true;
            tempFreq[c - 'a']++;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(maxLength(new ArrayList<>(Arrays.asList("un", "iq", "ue")))); // Expected: 4
        System.out.println(maxLength(new ArrayList<>(Arrays.asList("cha", "r", "act", "ers")))); // Expected: 6
        System.out.println(maxLength(new ArrayList<>(List.of("abcdefghijklmnopqrstuvwxyz")))); // Expected: 26
    }
}

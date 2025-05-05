// 1433. Check If a String Can Break Another String
package Medium;
import java.util.Arrays;

public class Medium_1433_Check_If_a_String_Can_Break_Another_String {
    public static boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        boolean s1Flag = true, s2Flag = true;

        char[] crr1 = s1.toCharArray();
        Arrays.sort(crr1);

        char[] crr2 = s2.toCharArray();
        Arrays.sort(crr2);

        for (int i=0; i<n; i++) {
            if (s1Flag)
                s1Flag = crr1[i] >= crr2[i];
            if (s2Flag)
                s2Flag = crr2[i] >= crr1[i];
            if (!s1Flag && !s2Flag) break;
        }
        return s1Flag || s2Flag;
    }

    // Optimized Approach
    public static boolean checkIfCanBreakOpt(String s1, String s2) {
        int[] freq1 = getFrequency(s1.toCharArray());
        int[] freq2 = getFrequency(s2.toCharArray());
        return canBreak(freq1, freq2) || canBreak(freq2, freq1);
    }
    private static int[] getFrequency(char[] arr) {
        int[] freq = new int[26];
        for (char c : arr) freq[c-'a']++;

        for (int i=1; i<26; i++)
            freq[i] += freq[i-1];
        return freq;
    }
    private static boolean canBreak(int[] c1, int[] c2) {
        for (int i=0; i<26; i++)
            if (c1[i] < c2[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("abc", "xya"));
        System.out.println(checkIfCanBreak("abe", "acd"));
        System.out.println(checkIfCanBreak("leetcodee", "interview"));
    }
}

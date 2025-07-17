// 1525. Number of Good Ways to Split a String
package Medium;
import java.util.Arrays;

public class Medium_1525_Number_of_Good_Ways_to_Split_a_String {
    public static int numSplits(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int distinctCount = 0;

        int[] dLeft = new int[n];
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (++freq[c-'a'] == 1)
                ++distinctCount;
            dLeft[i] = distinctCount;
        }

        Arrays.fill(freq, 0);
        distinctCount = 0;
        int answer = 0;

        for (int i=n-1; i>=1; i--) {
            char c = s.charAt(i);
            if (++freq[c-'a'] == 1)
                distinctCount++;

            if (distinctCount == dLeft[i-1])
                answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(numSplits("aacaba"));
        System.out.println(numSplits("abcd"));
    }
}

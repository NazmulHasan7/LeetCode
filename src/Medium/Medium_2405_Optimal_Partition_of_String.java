// 2405. Optimal Partition of String
package Medium;
import java.util.Arrays;

public class Medium_2405_Optimal_Partition_of_String {
    public static int partitionString(String s) {
        int[] freq = new int[26];

        int answer = 0;
        for (char c : s.toCharArray()) {
            if (freq[c-'a'] == 1) {
                answer++;
                Arrays.fill(freq,0);
            }
            freq[c-'a'] = 1;
        }
        return answer + 1;
    }
    public static void main(String[] args) {
        System.out.println(partitionString("abacaba"));
        System.out.println(partitionString("ssssss"));
    }
}

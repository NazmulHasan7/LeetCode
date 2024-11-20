// 1647. Minimum Deletions to Make Character Frequencies Unique
package Medium;
import java.util.Arrays;

public class Medium_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique {
    // TC -> O(n * log(n)), SC -> O(26)
    public static int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;

        Arrays.sort(freq);

        int count = 0;
        for (int i=24; i>=0; i--) {
            if (freq[i] != 0) {
                if (freq[i+1] == freq[i]) {
                    freq[i]--;
                    count++;
                } else if (freq[i+1] < freq[i]) {
                    int target = freq[i+1] - 1;
                    if (target < 0) target = 0;
                    count += freq[i] - target;
                    freq[i] = target;
                }
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));
    }
}

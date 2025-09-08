// 3325. Count Substrings With K-Frequency Characters I
package Medium;

public class Medium_3325_Count_Substrings_With_K_Frequency_Characters_I {
    // Brute force approach
    public static int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int left=0; left<n; left++) {
            int[] freq = new int[26];
            for (int right=left; right<n; right++) {
                int idx = s.charAt(right) - 'a';
                freq[idx]++;
                if (freq[idx] == k) {
                    count += n-right;
                    break;
                }
            }
        } return count;
    }
    public static int numberOfSubstringsOpt(String s, int k) {
        int n = s.length();
        int count = 0;
        int[] freq = new int[26];

        for (int left=0, right=0; right<n; right++) {
            char c = s.charAt(right);
            freq[c-'a']++;

            while (freq[c-'a'] >= k) {
                count += (n-right);
                freq[s.charAt(left)-'a']--;
                left++;
            }

        } return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSubstringsOpt("abacb", 2));
        System.out.println(numberOfSubstringsOpt("abcde", 1));
    }
}

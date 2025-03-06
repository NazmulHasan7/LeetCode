// 1781. Sum of Beauty of All Substrings
package Medium;

public class Medium_1781_Sum_of_Beauty_of_All_Substrings {
    public static int beautySum(String s) {
        int n = s.length();
        int score = 0;

        for (int i=0; i<n; i++) {
            int[] freq = new int[26];

            for (int j=i; j<n; j++) {
                int idx = s.charAt(j) - 'a';
                freq[idx]++;

                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;
                for (int k=0; k<26; k++) {
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }
                score += maxFreq - minFreq;
            }
        } return score;
    }
    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
        System.out.println(beautySum("aabcbaa"));
    }
}

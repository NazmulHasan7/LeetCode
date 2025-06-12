// 3085. Minimum Deletions to Make String K-Special
package Medium;

public class Medium_3085_Minimum_Deletions_to_Make_String_K_Special {
    public static int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for (char c : word.toCharArray())
            freq[c-'a']++;

        int minDeletion = Integer.MAX_VALUE;
        for (int i=0; i<26; i++) { // compare all others frequency with i
            if (freq[i] != 0) {
                int deletion = 0; // general formula -> |x - (x+k)| <= k

                for (int j=0; j<26; j++) {
                    if (i != j && freq[j] != 0) {
                        if (freq[j] < freq[i])
                            deletion += freq[j]; // delete all of j
                        else if (freq[j] > freq[i]+k)
                            deletion += freq[j] - (freq[i] + k); // delete excess of j
                    }
                } minDeletion = Math.min(minDeletion, deletion);
            }
        } return minDeletion;
    }
    public static void main(String[] args) {
        System.out.println(minimumDeletions("aabcaba", 0));
        System.out.println(minimumDeletions("dabdcbdcdcd", 2));
        System.out.println(minimumDeletions("aaabaaa", 2));
    }
}

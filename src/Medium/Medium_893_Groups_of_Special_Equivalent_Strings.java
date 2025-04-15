// 893. Groups of Special-Equivalent Strings
package Medium;
import java.util.Arrays;
import java.util.HashSet;

public class Medium_893_Groups_of_Special_Equivalent_Strings {
    public static int numSpecialEquivGroups(String[] words) {
        int n = words.length;
        // set stores the indices that are already found special equivalent
        HashSet<Integer> specials = new HashSet<>();
        int group = 0;

        for (int i=0; i<n; i++) { // O(n * n * len of word)
            if (!specials.contains(i)) {
                group++;
                specials.add(i);

                int[] evenFreq = new int[26];
                int[] oddFreq = new int[26];
                int len = words[i].length();

                for (int j=0; j<len; j++) {
                    int c = words[i].charAt(j)-'a';
                    if ((j & 1) == 0) evenFreq[c]++;
                    else oddFreq[c]++;
                }

                // Now check for every other words that are not special till now
                for (int k=i+1; k<n; k++) {
                    if (!specials.contains(k)) {
                        if (isSpecialEquivalent(evenFreq, oddFreq, words[k]))
                            specials.add(k);
                    }
                }
            }
        } return group;
    }
    private static boolean isSpecialEquivalent(int[] evenFreq, int[] oddFreq, String word) {
        // in one move we can swap any two even or odd index characters
        // so the even and odd indices chars of two strings have to be same
        int n = word.length();
        int[] evenCopy = evenFreq.clone();
        int[] oddCopy = oddFreq.clone();

        for (int i=0; i<n; i++) {
            int c = word.charAt(i)-'a';
            if ((i & 1) == 0) evenCopy[c]--;
            else oddCopy[c]--;
        }
        for (int i=0; i<26; i++)
            if (evenCopy[i] != 0 || oddCopy[i] != 0)
                return false;
        return true;
    }

    // Optimized Approach
    public static int numSpecialEquivGroupsOpt(String[] words) {
        HashSet<String> signatures = new HashSet<>();

        for (String word : words) {
            int[] even = new int[26];
            int[] odd = new int[26];
            for (int i=0; i<word.length(); i++) {
                int c = word.charAt(i)-'a';
                if ((i & 1) == 0) even[c]++;
                else odd[c]++;
            }
            String signature = Arrays.toString(even) + Arrays.toString(odd);
            signatures.add(signature);
        }
        return signatures.size();
    }

    public static void main(String[] args) {
        System.out.println(numSpecialEquivGroups(new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"}));
        System.out.println(numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));
    }
}

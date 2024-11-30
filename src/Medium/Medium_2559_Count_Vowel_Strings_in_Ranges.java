// 2559. Count Vowel Strings in Ranges
package Medium;
import java.util.Arrays;

public class Medium_2559_Count_Vowel_Strings_in_Ranges {
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] preCount = new int[n+1];

        int count = 0;
        for (int i=0; i<n; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1)))
                count++;
            preCount[i+1] = count;
        }

        int m = queries.length;
        int[] answer = new int[m];
        for (int i=0; i<m; i++)
            answer[i] = preCount[queries[i][1]+1] - preCount[queries[i][0]];

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(vowelStrings(new String[]{"aba","bcb","ece","aa","e"}, new int[][]{{0,2},{1,4},{1,1}})));
        System.out.println(Arrays.toString(vowelStrings(new String[]{"a","e","i"}, new int[][]{{0,2},{0,1},{2,2}})));
    }
}

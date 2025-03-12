// 2063. Vowels of All Substrings
package Medium;

public class Medium_2063_Vowels_of_All_Substrings {
    // prefix sum approach -> TLE TC O(n^2) SC -> O(n)
    public static long countVowels(String word) {
        int n = word.length();
        int vowels = 0;
        int[] prefix = new int[n+1];

        for (int i=0; i<n; i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowels++;
            prefix[i+1] = vowels;
        }

        long total = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                total += (prefix[j] - prefix[i]);
            }
        }
        return total;
    }
    // optimized approach -> Linear TC & constant SC
    // If a character is vowel, then how many substrings will contain that char ?
    // LEFT substrings (including the current char) * RIGHT substring
    public static long countVowelsOpt(String word) {
        long count = 0;
        int n = word.length();

        for (int i=0; i<n; i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count += (long) (i + 1) * (n-i);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countVowels("aba"));
        System.out.println(countVowels("abc"));
        System.out.println(countVowels("ltcd"));
    }
}

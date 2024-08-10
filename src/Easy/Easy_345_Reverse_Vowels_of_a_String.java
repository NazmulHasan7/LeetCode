// 345. Reverse Vowels of a String
package Easy;

public class Easy_345_Reverse_Vowels_of_a_String {
    public static boolean isVowel(char c) {
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
                || c=='A' || c=='E' || c=='I' || c=='O' || c=='U');
    }
    public static String reverseVowels(String s) {
        char[] crr = s.toCharArray();
        char temp;
        for (int i=0, j=crr.length-1; i<j; ) {
            if (isVowel(crr[i]) && isVowel(crr[j])) {
                temp = crr[i];
                crr[i] = crr[j];
                crr[j] = temp;
                i++; j--;
            }
            else if (!isVowel(crr[i])) i++;
            else if (!isVowel(crr[j])) j--;
            else {
                i++; j--;
            }
        } return String.valueOf(crr);
    }
    public static String reverseVowelsBetter(String s) {
        boolean[] vowels = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray())
            vowels[c] = true;

        char[] crr = s.toCharArray();
        char temp;
        for (int i=0, j=crr.length-1; i<j; ) {
            if (vowels[crr[i]] && vowels[crr[j]]) {
                temp = crr[i];
                crr[i] = crr[j];
                crr[j] = temp;
                i++; j--;
            }
            else if (!vowels[crr[i]]) i++;
            else if (!vowels[crr[j]]) j--;
            else {
                i++; j--;
            }
        } return String.valueOf(crr);
    }
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowelsBetter("hello"));
        System.out.println(reverseVowelsBetter("leetcode"));
    }
}

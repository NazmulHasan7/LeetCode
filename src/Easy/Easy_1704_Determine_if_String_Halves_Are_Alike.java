// 1704. Determine if String Halves Are Alike
package Easy;

public class Easy_1704_Determine_if_String_Halves_Are_Alike {
    public static int countVowel(char[] cArr) {
        int count = 0;
        for (char c : cArr)
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                count++;
        return count;
    }
    public static boolean halvesAreAlike(String s) {
        int length = s.length();
        String s1 = s.substring(0, length/2);
        String s2 = s.substring(length/2);
        return countVowel(s1.toCharArray()) == countVowel(s2.toCharArray());
    }
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlike("AbCdEfGh")); // true
    }
}

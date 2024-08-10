// 2309. Greatest English Letter in Upper and Lower Case
package Easy;

public class Easy_2309_Greatest_English_Letter_in_Upper_and_Lower_Case {
    public static String greatestLetter(String s) {
        int[] freqLow = new int[26];
        int[] freqCap = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c))
                freqLow[c-'a']++;
            else freqCap[c-'A']++;
        }
        for (int i=25; i>=0; i--)
            if (freqLow[i] > 0 && freqCap[i] > 0)
                return String.valueOf((char)('A'+i));
        return "";
    }
    public static String greatestLetterBetter(String s) {
        for(char c='Z'; c>='A'; c--)
            if (s.indexOf(c) != -1 && s.indexOf(Character.toLowerCase((c))) != -1)
                return String.valueOf(c);
        return "";
    }
    public static void main(String[] args) {
        System.out.println(greatestLetter("lEeTcOdE"));
        System.out.println(greatestLetter("arRAzFif"));
        System.out.println(greatestLetter("AbCdEfGhIjK"));
    }
}

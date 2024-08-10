// 1832. Check if the Sentence Is Pangram
package Easy;

public class Easy_1832_Check_if_the_Sentence_Is_Pangram {
    public static boolean checkIfPangram(String sentence) {
        int[] letters = new int[26];
        for (char c : sentence.toCharArray())
            letters[c-'a']++;
        for (int letter : letters)
            if (letter == 0) return false;
        return true;
    }
    public static boolean checkIfPangramBetter(String sentence) {
        for (char c='a'; c<='z'; c++)
            if (sentence.indexOf(c) < 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkIfPangramBetter("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangramBetter("leetcode"));
    }
}

// 3227. Vowels Game in a String
package Medium;

public class Medium_3227_Vowels_Game_in_a_String {
    public static boolean doesAliceWin(String s) {
        int vCount = 0;
        for (char c : s.toCharArray())
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vCount++;

        // If vowel count is 0, then Alice loses
        // Otherwise Alice always wins (For even count, Alice leaves 1 vowel for Bob)
        // For Odd count Alice takes all the vowels
        return vCount != 0;
    }
    public static boolean doesAliceWinOpt(String s) {
        for (char c : s.toCharArray())
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                return true;

        // If vowel count is 0, then Alice loses
        // Otherwise Alice always wins (For even count, Alice leaves 1 vowel for Bob)
        // For Odd count Alice takes all the vowels
        return false;
    }
    public static void main(String[] args) {
        System.out.println(doesAliceWin("leetcoder"));
        System.out.println(doesAliceWin("bbcd"));
    }
}

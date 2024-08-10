// 520. Detect Capital
package Easy;

public class Easy_520_Detect_Capital {
    public static boolean isLowerCase(String word, int length) {
        for (int i=1; i<length; i++)
            if (!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z'))
                return false;
        return true;
    }
    public static boolean isUpperCase(String word, int length) {
        for (int i=1; i<length; i++)
            if (!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'))
                return false;
        return true;
    }
    public static boolean detectCapitalUse(String word) {
        int length = word.length();
        if (length < 2) return true;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')
            return (isUpperCase(word, length) || isLowerCase(word, length));
        else return isLowerCase(word, length);
    }
    public static boolean detectCapitalUseBetter(String word) {
        int length = word.length();
        int capCount = 0;
        for (char c : word.toCharArray())
            if (Character.isUpperCase(c))
                capCount++;
        // Handle lowercase and uppercase
        if (capCount == 0 || capCount == length)
            return true;
            // Handle Sentence case
        else return Character.isUpperCase(word.charAt(0)) && capCount == 1;
    }
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUseBetter("USA"));
        System.out.println(detectCapitalUseBetter("FlaG"));
    }
}

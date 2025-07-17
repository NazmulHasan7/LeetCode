// 3136. Valid Word
package Easy;

public class Easy_3136_Valid_Word {
    public static boolean isValid(String word) {
        if (word.length() < 3)
            return false;

        boolean hasVow = false, hasCons = false;
        for (char c : word.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char uc = Character.toUpperCase(c);
                if (uc == 'A' || uc == 'E' || uc == 'I' || uc == 'O' || uc == 'U')
                    hasVow = true;
                else hasCons = true;
            } else if (!Character.isDigit(c))
                return false;
        }
        return hasVow && hasCons;
    }
    public static void main(String[] args) {
        System.out.println(isValid("234Adas"));
        System.out.println(isValid("b3"));
        System.out.println(isValid("a3$e"));
    }
}

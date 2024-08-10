// 824. Goat Latin
package Easy;

public class Easy_824_Goat_Latin {
    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
    public static String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        StringBuilder a = new StringBuilder();
        String[] strArr = sentence.split(" ");

        for (String str : strArr) {
            a.append("a");
            if (isVowel(str.charAt(0))) {
                result.append(str);
            } else {
                result.append(str.substring(1));
                result.append(str.charAt(0));
            }
            result.append("ma");
            result.append(a);
            result.append(" ");
        } return result.toString().strip();
    }
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}

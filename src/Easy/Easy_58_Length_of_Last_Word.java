// 58. Length of Last Word
package Easy;

public class Easy_58_Length_of_Last_Word {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            length++;
        } return length;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}

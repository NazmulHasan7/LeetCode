// 557. Reverse Words in a String III
package Easy;

public class Easy_557_Reverse_Words_in_a_String_III {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int k=word.length()- 1; k>=0; k--)
                sb.append(word.charAt(k));
            sb.append(' ');
        } return sb.toString().trim();
    }
    public static String reverseWordsBetter(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder revWord;
        for (String word : words) {
            revWord = new StringBuilder(word);
            revWord.reverse();
            sb.append(revWord).append(" ");
        } return sb.toString().trim();
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("Mr Ding"));
        System.out.println(reverseWordsBetter("Let's take LeetCode contest"));
        System.out.println(reverseWordsBetter("Mr Ding"));
    }
}

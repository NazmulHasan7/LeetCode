// 1451. Rearrange Words in a Sentence
package Medium;
import java.util.Arrays;

public class Medium_1451_Rearrange_Words_in_a_Sentence {
    public static String arrangeWords(String text) {
        String[] strs = text.split(" ");
        Arrays.sort(strs, (a, b) -> a.length() - b.length());

        StringBuilder sb = new StringBuilder();
        sb.append(strs[0].substring(0,1).toUpperCase() + strs[0].substring(1));

        for (int i=1; i<strs.length; i++) {
            sb.append(" ");
            sb.append(strs[i].toLowerCase());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(arrangeWords("Leetcode is cool"));
        System.out.println(arrangeWords("Keep calm and code on"));
        System.out.println(arrangeWords("To be or not to be"));
    }
}

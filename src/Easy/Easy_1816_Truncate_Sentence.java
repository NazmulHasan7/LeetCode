// 1816. Truncate Sentence
package Easy;

public class Easy_1816_Truncate_Sentence {
    public static String truncateSentence(String s, int k) {
        int count = 0, i=0;
        for (char c: s.toCharArray()) {
            if (c == ' ') count++;
            if (count == k) break;
            i++;
        }
        return s.substring(0, i);
    }
    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
    }
}

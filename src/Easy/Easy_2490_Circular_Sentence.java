// 2490. Circular Sentence
package Easy;

public class Easy_2490_Circular_Sentence {
    public static boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length()-1))
            return false;
        String[] words = sentence.split(" ");
        for (int i=0; i<words.length-1; i++)
            if (words[i].charAt(words[i].length()-1) != words[i+1].charAt(0))
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isCircularSentence("leetcode exercises sound delightful"));
        System.out.println(isCircularSentence("eetcode"));
        System.out.println(isCircularSentence("Leetcode is cool"));
    }
}

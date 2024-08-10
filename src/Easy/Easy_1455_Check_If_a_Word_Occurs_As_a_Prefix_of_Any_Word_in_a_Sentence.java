// 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
package Easy;

public class Easy_1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence {
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i=0; i<words.length; i++)
            if (words[i].startsWith(searchWord)) return i+1;
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(isPrefixOfWord("i am tired", "you"));
    }
}

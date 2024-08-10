// 2942. Find Words Containing Character
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_2942_Find_Words_Containing_Character {
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        for (int i=0; i<words.length; i++)
            if (words[i].indexOf(x) >= 0) indices.add(i);
        return indices;
    }
    public static void main(String[] args) {
        System.out.println(findWordsContaining(new String[] {"leet","code"}, 'e'));
        System.out.println(findWordsContaining(new String[] {"abc","bcd","aaaa","cbc"}, 'a'));
        System.out.println(findWordsContaining(new String[] {"abc","bcd","aaaa","cbc"}, 'z'));
    }
}

// 2788. Split Strings by Separator
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_2788_Split_Strings_by_Separator {
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> str = new ArrayList<>();
        StringBuilder currentWord;
        for (String word : words) {
            currentWord = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c != separator) {
                    currentWord.append(c);
                } else if (!currentWord.isEmpty()) {
                    str.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }
            } if (!currentWord.isEmpty())
                str.add(currentWord.toString());
        } return str;
    }
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("one.two.three");
        list1.add("four.five");
        list1.add("six");
        System.out.println(splitWordsBySeparator(list1, '.'));
    }
}

// 1078. Occurrences After Bigram
package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class Easy_1078_Occurrences_After_Bigram {
    public static String[] findOccurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<words.length-2; i++)
            if (words[i].equals(first) && words[i+1].equals(second))
                list.add(words[i+2]);
        return list.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOccurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(findOccurrences("we will we will rock you", "we", "will")));
    }
}

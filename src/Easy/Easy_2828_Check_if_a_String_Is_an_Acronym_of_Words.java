// 2828. Check if a String Is an Acronym of Words
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_2828_Check_if_a_String_Is_an_Acronym_of_Words {
    public static boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : words)
            sb.append(word.charAt(0));
        return sb.toString().equals(s);
    }
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("alice");
        str.add("bob");
        str.add("charlie");
        System.out.println(isAcronym(str, "abc"));
    }
}

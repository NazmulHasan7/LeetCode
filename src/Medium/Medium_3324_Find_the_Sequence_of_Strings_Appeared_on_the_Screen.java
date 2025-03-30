// 3324. Find the Sequence of Strings Appeared on the Screen
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_3324_Find_the_Sequence_of_Strings_Appeared_on_the_Screen {
    public static List<String> stringSequence(String target) {
        List<String> answer = new ArrayList<>();

        StringBuilder screen = new StringBuilder();
        for (char tc : target.toCharArray()) {
            screen.append('a');
            answer.add(screen.toString());

            int n = screen.length();
            char ch = 'a';

            while (ch != tc) {
                ch = ((char) (ch + 1));
                screen.setCharAt(n-1, ch);
                answer.add(screen.toString());
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(stringSequence("abc"));
        System.out.println(stringSequence("he"));
    }
}

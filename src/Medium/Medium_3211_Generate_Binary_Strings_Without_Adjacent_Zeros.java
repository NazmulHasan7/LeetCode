// 3211. Generate Binary Strings Without Adjacent Zeros
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_3211_Generate_Binary_Strings_Without_Adjacent_Zeros {
    static List<String> answer;
    public static List<String> validStrings(int n) {
        answer = new ArrayList<>();
        backtrack(new StringBuilder(), n);
        return answer;
    }
    private static void backtrack(StringBuilder sb, int n) {
        if (sb.length() == n) {
            answer.add(sb.toString());
            return;
        }
        if (sb.isEmpty() || sb.charAt(sb.length()-1) == '1') {
            sb.append('0');
            backtrack(sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append('1');
        backtrack(sb, n);
        sb.deleteCharAt(sb.length()-1);
    }
    public static void main(String[] args) {
        System.out.println(validStrings(3));
        System.out.println(validStrings(1));
    }
}

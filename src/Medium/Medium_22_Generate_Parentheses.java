// 22. Generate Parentheses
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_22_Generate_Parentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), answer);
        return answer;
    }
    private static void backtrack(int n, int open, int close, StringBuilder sb, List<String> arr) {
        if (sb.length() == 2 * n) {
            arr.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrack(n, open+1, close, sb, arr);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(n, open, close+1, sb, arr);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }
}

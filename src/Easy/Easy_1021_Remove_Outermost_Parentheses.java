// 1021. Remove Outermost Parentheses
package Easy;

public class Easy_1021_Remove_Outermost_Parentheses {
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (open > 0) sb.append(c);
                open++;
            } else {
                open--;
                if(open != 0) sb.append(c);
            }
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }
}

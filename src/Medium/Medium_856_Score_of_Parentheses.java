// 856. Score of Parentheses
package Medium;

public class Medium_856_Score_of_Parentheses {
    public static int scoreOfParentheses(String s) {
        int depth = 0, score = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i-1) == '(')
                    score += (int) (Math.pow(2, depth));
            }
        } return score;
    }
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(()(()))"));
    }
}

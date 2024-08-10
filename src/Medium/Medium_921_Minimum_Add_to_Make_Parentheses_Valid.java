// 921. Minimum Add to Make Parentheses Valid
package Medium;

public class Medium_921_Minimum_Add_to_Make_Parentheses_Valid {
    public static int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')' && open > 0) open--;
            else close++;
        } return open + close;
    }
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
    }
}

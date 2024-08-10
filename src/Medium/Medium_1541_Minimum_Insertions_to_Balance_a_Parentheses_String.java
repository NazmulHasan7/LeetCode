// 1541. Minimum Insertions to Balance a Parentheses String
package Medium;

public class Medium_1541_Minimum_Insertions_to_Balance_a_Parentheses_String {
    public static int minInsertions(String s) {
        int openCount = 0, addOpen = 0, addClose = 0;
        int idx = 0, length = s.length();

        while (idx < length) {
            char c = s.charAt(idx);
            if (c == '(') openCount++;
            else {
                if (idx+1 < length && s.charAt(idx+1) == ')') {
                    // if ()) -> pop (
                    if (openCount > 0) openCount--;
                    else addOpen++; // else add a (
                    idx++;
                } else {
                    addClose++; // another ) is missing -> added one
                    // Since it became )) -> pop ( if exists
                    if (openCount > 0) openCount--;
                    else addOpen++; // else add a (
                }
            } idx++;
        } return openCount * 2 + addOpen + addClose;
    }
    public static void main(String[] args) {
        System.out.println(minInsertions("(()))"));
        System.out.println(minInsertions("())"));
        System.out.println(minInsertions("))())("));
        System.out.println(minInsertions(")))))))"));
    }
}

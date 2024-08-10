// 1047. Remove All Adjacent Duplicates In String
package Easy;
import java.util.Stack;

public class Easy_1047_Remove_All_Adjacent_Duplicates_In_String {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
    public static String removeDuplicatesBetter(String s){
        int index = -1;
        char[] cArr = s.toCharArray();
        for (char c : cArr) {
            if (index >= 0 && cArr[index] == c)
                index--;
            else cArr[++index] = c;
        } return String.valueOf(cArr, 0, index+1);
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicatesBetter("azxxzy"));
        System.out.println(removeDuplicatesBetter("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }
}

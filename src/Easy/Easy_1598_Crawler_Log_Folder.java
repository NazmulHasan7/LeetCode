// 1598. Crawler Log Folder
package Easy;
import java.util.Stack;

public class Easy_1598_Crawler_Log_Folder {
    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String str : logs) {
            if (str.equals("../")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!str.equals("./"))
                stack.push(str);
        } return stack.size();
    }
    public static int minOperationsBetter(String[] logs) {
        int length = 0;
        for (String str : logs) {
            if (str.equals("../")) {
                if (length > 0)
                    length--;
            } else if (!str.equals("./"))
                length++;
        } return length;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new String[] {"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println(minOperations(new String[] {"d1/","../","../","../"}));
        System.out.println(minOperationsBetter(new String[] {"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println(minOperationsBetter(new String[] {"d1/","../","../","../"}));
    }
}

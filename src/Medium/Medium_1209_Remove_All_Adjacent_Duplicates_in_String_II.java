// 1209. Remove All Adjacent Duplicates in String II
package Medium;
import java.util.Stack;

public class Medium_1209_Remove_All_Adjacent_Duplicates_in_String_II {
    static class Pair {
        char c;
        int count;
        public Pair (char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c)
                stack.peek().count++;
            else stack.push(new Pair(c, 1));

            if (stack.peek().count == k) stack.pop();
        }
        StringBuilder result = new StringBuilder();
        for (Pair p : stack)
            result.append(String.valueOf(p.c).repeat(p.count));
        return result.toString();
    }
    public static String removeDuplicatesBetter(String s, int k) {
        Pair[] stack = new Pair[s.length()];
        int stackPtr = -1;
        for (char c : s.toCharArray()) {
            if (stackPtr > -1 && stack[stackPtr].c == c)
                stack[stackPtr].count++;
            else stack[++stackPtr] = new Pair(c, 1);

            if (stack[stackPtr].count == k) stackPtr--;
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index <= stackPtr) {
            result.append(String.valueOf(stack[index].c).repeat(stack[index].count));
            index++;
        } return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(removeDuplicatesBetter("abcd", 2));
        System.out.println(removeDuplicatesBetter("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicatesBetter("pbbcggttciiippooaais", 2));
    }
}

// 388. Longest Absolute File Path
package Medium;
import java.util.Stack;

public class Medium_388_Longest_Absolute_File_Path {
    public static int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (String line : lines) {
            System.out.println(line);
            int level = line.lastIndexOf("\t") + 1;
            while (stack.size()-1 > level)
                stack.pop();

            int length = stack.peek() + 1 + line.length() - level;
            // +1 for / and - level to ignore extra spaces
            if (line.contains("."))
                maxLen = Math.max(maxLen, length-1); // no / at the end of file
            else stack.push(length);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}

// 1614. Maximum Nesting Depth of the Parentheses
package Easy;

public class Easy_1614_Maximum_Nesting_Depth_of_the_Parentheses {
    public static int maxDepth(String s) {
        int open = 0, depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')') open--;
            depth = Math.max(depth, open);
        } return depth;
    }
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }
}

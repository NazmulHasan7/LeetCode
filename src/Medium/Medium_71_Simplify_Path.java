// 71. Simplify Path
package Medium;

public class Medium_71_Simplify_Path {
    public static String simplifyPath(String path) {
        String[] srr = path.split("/");
        String[] stack = new String[srr.length];
        int stackPtr = -1;

        for (String str : srr) {
            if (str.equals("..")) {
                if (stackPtr > -1) stackPtr--;
            } else if (!str.isEmpty() && !str.equals(".")) {
                stack[++stackPtr] = "/" + str;
            } else continue;
        }
        StringBuilder canonicalPath = new StringBuilder();
        int idx = 0;
        while (idx <= stackPtr)
            canonicalPath.append(stack[idx++]);

        if (canonicalPath.isEmpty()) return "/";
        return canonicalPath.toString();
    }
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../../../usr/local/bin"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/home/user/./Downloads/../Pictures/././"));
    }
}

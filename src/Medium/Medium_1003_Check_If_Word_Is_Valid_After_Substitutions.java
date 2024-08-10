// 1003. Check If Word Is Valid After Substitutions
package Medium;

public class Medium_1003_Check_If_Word_Is_Valid_After_Substitutions {
    public static boolean isValid(String s) {
        while (s.contains("abc"))
            s = s.replaceAll("abc", "");
        return s.isEmpty();
    }
    // Linear time solution -> O(n)
    public static boolean isValidBetter(String s) {
        char[] stack = new char[s.length()];
        int stackPtr = -1;
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (stackPtr > 0 && stack[stackPtr] == 'b' && stack[stackPtr-1] == 'a')
                    stackPtr = stackPtr - 2;
                else stack[++stackPtr] = c;
            } else stack[++stackPtr] = c;
        } return stackPtr == -1;
    }
    public static void main(String[] args) {
        System.out.println(isValid("aabcbc"));
        System.out.println(isValid("abcabcababcc"));
        System.out.println(isValid("abccba"));
    }
}

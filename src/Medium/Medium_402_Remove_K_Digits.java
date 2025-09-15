// 402. Remove K Digits
package Medium;

public class Medium_402_Remove_K_Digits {
    public static String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0";

        char[] stack = new char[n];
        int stackTop = -1;
        int remove = k;

        for (char digit : num.toCharArray()) {
            while (remove > 0 && stackTop >= 0 && stack[stackTop] > digit) {
                stackTop--;
                remove--;
            }
            stackTop++;
            stack[stackTop] = digit;
        }

        int nonZeroStart = 0;
        while (stack[nonZeroStart] == '0' && nonZeroStart < n - k - 1)
            nonZeroStart++;
        return String.valueOf(stack, nonZeroStart, n - k - nonZeroStart);
    }
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }
}

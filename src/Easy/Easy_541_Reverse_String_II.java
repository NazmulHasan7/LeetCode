// 541. Reverse String II
package Easy;

public class Easy_541_Reverse_String_II {
    public static void reverse(char[] crr, int start, int end) {
        while (start < end) {
            char x = crr[start];
            crr[start++] = crr[end];
            crr[end--] = x;
        }
    }
    public static String reverseStr(String s, int k) {
        char[] crr = s.toCharArray();
        int length = s.length();

        for (int i=0; i<length; i+=2*k) {
            if (i+k-1 < length)
                reverse(crr, i, i+k-1);
            else reverse(crr, i, length-1);
        } return new String(crr);
    }
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("abcd", 2));
    }
}

// 344. Reverse String
package Easy;

public class Easy_344_Reverse_String {
    public static void reverseString(char[] s) {
        char temp;
        int i = 0, j = s.length-1;
        while (i < j) {
            temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        } System.out.println(s);
    }
    public static void main(String[] args) {
        reverseString(new char[] {'h', 'e', 'l', 'l', 'o'});
        reverseString(new char[] {'H', 'a', 'n', 'n', 'a', 'h'});
    }
}

// 2696. Minimum String Length After Removing Substrings
package Easy;

public class Easy_2696_Minimum_String_Length_After_Removing_Substrings {
    public static int minLength(String s) {
        int index = -1;
        int[] stack = new int[s.length()];
        for (char c : s.toCharArray()) {
            if (index >= 0 && (c == 'B' && stack[index] == 'A'
                    || c == 'D' && stack[index] == 'C'))
                index--;
            else stack[++index] = c;
        } return index+1;
    }
    public static void main(String[] args) {
        System.out.println(minLength("ABFCACDB"));
        System.out.println(minLength("ACBBD"));
    }
}

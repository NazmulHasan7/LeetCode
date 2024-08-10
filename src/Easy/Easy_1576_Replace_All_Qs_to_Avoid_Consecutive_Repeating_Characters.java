// 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
package Easy;

public class Easy_1576_Replace_All_Qs_to_Avoid_Consecutive_Repeating_Characters {
    public static char getChar(char prev, char next) {
        for (char c='a'; c<='z'; c++)
            if (c != prev && c != next) return c;
        return '@';
    }
    public static String modifyString(String s) {
        char[] crr = s.toCharArray();
        int length = crr.length;

        char prev, next;
        for (int i=0; i<length; i++) {
            if (crr[i] == '?') {
                prev = (i == 0) ? ' ' : crr[i-1];
                next = (i == length-1) ? ' ' : crr[i+1];
                crr[i] = getChar(prev, next);
            }
        } return new String(crr);
    }
    public static void main(String[] args) {
        System.out.println(modifyString("?zs"));
        System.out.println(modifyString("ubv?w"));
        System.out.println(modifyString("u?v?w"));
    }
}

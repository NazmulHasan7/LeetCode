// 925. Long Pressed Name
package Easy;

public class Easy_925_Long_Pressed_Name {
    public static boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();
        int namePtr = 0;
        char prevChar = ' ';

        if (name.charAt(namePtr) != typed.charAt(0))
            return false;

        for (int i=0; i<m; i++) {
            char c = typed.charAt(i);
            if (namePtr < n && c == name.charAt(namePtr)) {
                namePtr++;
                prevChar = c;
            } else if (prevChar != ' ' && c != prevChar) {
                return false;
            }
        }
        return namePtr == n;
    }
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
    }
}

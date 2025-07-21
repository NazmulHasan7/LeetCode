// 3612. Process String with Special Operations I
package Medium;

public class Medium_3612_Process_String_with_Special_Operations_I {
    public static String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c == '*') {
                if (!sb.isEmpty())
                    sb.deleteCharAt(sb.length() - 1);
            } else if (c == '#') {
                sb.append(sb);
            } else if (c == '%') {
                sb.reverse();
            }
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(processStr("a#b%*"));
        System.out.println(processStr("z*#"));
    }
}

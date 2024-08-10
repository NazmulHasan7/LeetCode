// 1957. Delete Characters to Make Fancy String
package Easy;

public class Easy_1957_Delete_Characters_to_Make_Fancy_String {
    public static String makeFancyString(String s) {
        int length = s.length();
        if (length < 2) return s;

        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, 2);
        for (int i=2; i<length; i++) {
            if (!(s.charAt(i) == s.charAt(i-1) && s.charAt(i-1) == s.charAt(i-2)))
                sb.append(s.charAt(i));
        } return sb.toString();
    }
    public static String makeFancyStringBetter(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = '\0';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
                if (count <= 2) sb.append(c);
            } else {
                prev = c;
                count = 1;
                sb.append(c);
            }
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
        System.out.println(makeFancyString("aaabaaaa"));
        System.out.println(makeFancyStringBetter("leeetcode"));
        System.out.println(makeFancyStringBetter("aaabaaaa"));
    }
}

// 1910. Remove All Occurrences of a Substring
package Medium;

public class Medium_1910_Remove_All_Occurrences_of_a_Substring {
    public static String removeOccurrences(String s, String part) {
        // O(size of s * size of part)
        while (true) {
            int idx = s.indexOf(part);
            if (idx == -1) break;
            s = s.substring(0, idx) + s.substring(idx + part.length());
        }
        return s;
    }
    public static String removeOccurrencesOpt(String s, String part) {
        int n = part.length();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);
            int m = sb.length();
            if (m >= n && sb.substring(m - n).equals(part))
                sb.delete(m-n, m);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(removeOccurrences("axxxxyyyyb", "xy"));
        System.out.println(removeOccurrencesOpt("daabcbaabcbc", "abc"));
        System.out.println(removeOccurrencesOpt("axxxxyyyyb", "xy"));
    }
}

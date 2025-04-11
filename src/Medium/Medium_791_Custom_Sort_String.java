// 791. Custom Sort String
package Medium;

public class Medium_791_Custom_Sort_String {
    public static String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (freq[c-'a']-- > 0)
                sb.append(c);
        }

        for (int i=0; i<26; i++)
            while (freq[i]-- > 0)
                sb.append((char)('a'+i));

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(customSortString("bcafg", "abcd"));
    }
}

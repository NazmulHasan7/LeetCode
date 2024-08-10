// 1961. Check If String Is a Prefix of Array
package Easy;

public class Easy_1961_Check_If_String_Is_a_Prefix_of_Array {
    public static boolean isPrefixString(String s, String[] words) {
        String result = "";
        int length = s.length();
        for (String word: words) {
            result += word;
            if (s.equals(result)) return true;
            if (result.length() > length) return false;
        } return false;
    }
    public static boolean isPrefixStringBetter(String s, String[] words) {
        for (String word : words) {
            if (!s.startsWith(word)) return false;
            s = s.substring(word.length());
            if (s.isEmpty()) return true;
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(isPrefixStringBetter("iloveleetcode",
                new String[] {"i","love","leetcode","apples"}));
        System.out.println(isPrefixStringBetter("iloveleetcode",
                new String[] {"apples","i","love","leetcode"}));
    }
}

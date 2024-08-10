// 242. Valid Anagram
package Easy;
import java.util.Arrays;

public class Easy_242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        char[] srr = s.toCharArray();
        char[] trr = t.toCharArray();
        Arrays.sort(srr);
        Arrays.sort(trr);
        String s1 = new String(srr);
        String t1 = new String(trr);
        return s1.equals(t1);
    }
    public static boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arr = new int[26];
        for (char c : s.toCharArray())
            arr[c - 'a']++;
        for (char c : t.toCharArray())
            arr[c - 'a']--;
        for (int n : arr)
            if (n != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagramBetter("anagram", "nagaram"));
        System.out.println(isAnagramBetter("rat", "car"));
    }
}

// 205. Isomorphic Strings
package Easy;
import java.util.HashMap;

public class Easy_205_Isomorphic_Strings {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int length = s.length();
        for (int i=0; i<length; i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            } else if (map.get(s.charAt(i)) != t.charAt(i))
                return false;
        } return true;
    }
    public static boolean isIsomorphicBetter(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        // Each character is associated with a unique index in the mapping arrays
        for (int index=0; index<s.length(); index++) {
            if (sMap[s.charAt(index)] != tMap[t.charAt(index)])
                return false;
            sMap[s.charAt(index)] = index+1;
            tMap[t.charAt(index)] = index+1;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphicBetter("egg", "add"));
        System.out.println(isIsomorphicBetter("badc", "baba"));
    }
}

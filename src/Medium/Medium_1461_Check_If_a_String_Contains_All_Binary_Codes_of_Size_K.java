// 1461. Check If a String Contains All Binary Codes of Size K
package Medium;
import java.util.HashSet;

public class Medium_1461_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
    public static boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        // Sliding Window Approach
        int length = s.length()-k;
        int n = 1 << k; // Same as 2^k

        // The number of distinct sub-strings should be exactly 2^k.
        for (int i=0; i<=length; i++) {
            set.add(s.substring(i, i + k));
            if (set.size() == n) return true;
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110110", 2));
        System.out.println(hasAllCodes("0110", 1));
        System.out.println(hasAllCodes("0110", 2));
    }
}

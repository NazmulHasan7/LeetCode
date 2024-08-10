// 1790. Check if One String Swap Can Make Strings Equal
package Easy;
import java.util.Arrays;

public class Easy_1790_Check_if_One_String_Swap_Can_Make_Strings_Equal {
    public static boolean areAlmostEqual(String s1, String s2) {
        int length = s1.length();
        if (length != s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        char c1, c2;
        int counter = 0;

        for (int i=0; i<length; i++) {
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            if (c1 != c2) {
                counter++;
                if (counter > 2) return false;
            }
            freq1[c1-'a']++;
            freq2[c2-'a']++;
        } return Arrays.equals(freq1, freq2);
    }
    public static boolean areAlmostEqualBetter(String s1, String s2) {
        int length = s1.length();
        if (length != s2.length()) return false;
        else if (s1.equals(s2)) return true;

        int counter = 0;
        int[] indexes = new int[2];
        char c1, c2;
        for (int i=0; i<length; i++) {
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            if (c1 != c2) {
                if (counter+1 > 2) return false;
                indexes[counter++] = i;
            }
        } return counter == 2 && s1.charAt(indexes[0]) == s2.charAt(indexes[1]) &&
                s2.charAt(indexes[0]) == s1.charAt(indexes[1]);
    }
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("attack", "defend"));
        System.out.println(areAlmostEqual("kelb", "kelb"));
    }
}

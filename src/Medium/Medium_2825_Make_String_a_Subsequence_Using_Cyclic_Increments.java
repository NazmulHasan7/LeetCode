// 2825. Make String a Subsequence Using Cyclic Increments
package Medium;

public class Medium_2825_Make_String_a_Subsequence_Using_Cyclic_Increments {
    public static boolean canMakeSubsequence(String str1, String str2) {
        int s1 = str1.length();
        int s2 = str2.length();

        int i = 0, j = 0;
        while (i < s1 && j <s2) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);

            if (c1 == c2 || c1+1 == c2 || c1-25 == c2)
                j++;

            i++;
        }
        return j == s2;
    }
    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("abc", "ad"));
        System.out.println(canMakeSubsequence("zc", "ad"));
        System.out.println(canMakeSubsequence("ab", "d"));
    }
}

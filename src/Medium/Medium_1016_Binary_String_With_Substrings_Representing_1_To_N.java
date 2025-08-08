// 1016. Binary String With Substrings Representing 1 To N
package Medium;

public class Medium_1016_Binary_String_With_Substrings_Representing_1_To_N {
    public static boolean queryString(String s, int n) {
        for (int i=1; i<=n; i++)
            if (!s.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(queryString("0110",3));
        System.out.println(queryString("0110",4));
    }
}

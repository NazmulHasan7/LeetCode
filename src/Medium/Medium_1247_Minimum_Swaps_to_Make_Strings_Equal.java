// 1247. Minimum Swaps to Make Strings Equal
package Medium;

public class Medium_1247_Minimum_Swaps_to_Make_Strings_Equal {
    public static int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int xy = 0, yx = 0;

        for (int i=0; i<n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (c1 == 'x' && c2 == 'y')
                    xy++;
                else if (c1 == 'y' && c2 == 'x')
                    yx++;
            }
        }

        if (((xy + yx) & 1) == 1) // xy and yx can be swapped
            return -1; // there is at least one unmatched pair

        int case1 = xy/2 + yx/2; // xx yy => xy xy or yy xx => yx yx
        int case2 = xy%2 + yx%2; // xy yx => xx yy => xy xy
        return case1 + case2;
    }
    public static void main(String[] args) {
        System.out.println(minimumSwap("xx", "yy"));
        System.out.println(minimumSwap("xy", "yx"));
        System.out.println(minimumSwap("xx", "xy"));
    }
}

// 1318. Minimum Flips to Make a OR b Equal to c
package Medium;

public class Medium_1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c {
    public static int minFlips(int a, int b, int c) {
        int flipCount = 0;

        while (a != 0 || b != 0 || c != 0) {
            if ((c&1) == 1) {
                // any of a or b or both lsb can be 1
                if ((a&1) == 0 && (b&1) == 0)
                    flipCount++; // since both lsb is 0, need to flip at least 1
            } else {
                // since lsb of c is both a and b lsb have to be 0
                if ((a&1) == 1) flipCount++;
                if ((b&1) == 1) flipCount++;
            }
            a >>= 1; // right shift a
            b >>= 1; // right shift b
            c >>= 1; // right shift c
        }
        return flipCount;
    }
    public static void main(String[] args) {
        System.out.println(minFlips(2,6,5));
        System.out.println(minFlips(4,2,7));
        System.out.println(minFlips(1,2,3));
    }
}

// 693. Binary Number with Alternating Bits
package Easy;

public class Easy_693_Binary_Number_with_Alternating_Bits {
    public static boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        //System.out.println(Integer.toBinaryString(n));
        while (n != 0) {
            n >>= 1;
            //System.out.println(Integer.toBinaryString(n) + " " + Integer.toBinaryString(prev));
            if ((n&1) == prev) return false;
            prev = n & 1;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(6));
    }
}

// All patterns for bit manipulation
package Exercises;

public class Bit_Manipulation {
    private static boolean isSetBit(int num, int k) {
        // checks and return true if the kth bit is set otherwise false
        // Left shifts 1 by k-1, for k = 3, 0001 >> 2 => 0100
        // for n = 5 (0101) & (0100) => 0100 =>
        return (num & (1 << (k-1))) != 0;
    }
    private static int countSetBit(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num >>= 1; // right shift
        }
        return count;
    }
    private static boolean isPowerOfTwo(int num) {
        // if a number is a power of two then it has only one set bit
        // 10, 100, 1000 .... multiplying them with num - 1 gives 0 as output
        // 100 * 011 => 0
        return num > 0 && (num & (num-1)) == 0;
    }
    private static int clearBit(int num, int i) {
        // 1110 -> 1 >> (i(3)-1) -> 0100 -> ~(0100) -> 1011
        // 1110 & 1011 -> 1010
        return (num & ~(1 << (i-1)));
    }
    public static void main(String[] args) {
        System.out.println(isSetBit(10, 2));
        System.out.println(isSetBit(10, 3));
        System.out.println(countSetBit(15));
        System.out.println(countSetBit(128));
        System.out.println(countSetBit(10));
        System.out.println(clearBit(14,3));
    }
}

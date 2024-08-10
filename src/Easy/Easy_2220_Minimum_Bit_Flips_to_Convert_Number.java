// Easy_2220_Minimum_Bit_Flips_to_Convert_Number
package Easy;

public class Easy_2220_Minimum_Bit_Flips_to_Convert_Number {
    public static int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;
        while (xor > 0) {
            if ((xor & 1) == 1) count++;
            xor >>= 1;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
        System.out.println(minBitFlips(3, 4));
    }
}

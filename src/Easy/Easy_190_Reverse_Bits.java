// 190. Reverse Bits
package Easy;

public class Easy_190_Reverse_Bits {
    public static int reverseBits(int n) {
        int number = 0;

        for (int i=0; i<32; i++) {
            int currentBit = n & 1;
            number <<= 1; // multiply by 2
            number |= currentBit;
            n >>= 1; // divide by 2
        }
        return number;
    }
    public static void main(String[] args) {
        // System.out.println(reverseBits(00000010100101000001111010011100));
    }
}

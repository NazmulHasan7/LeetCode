// 2429. Minimize XOR
package Medium;

public class Medium_2429_Minimize_XOR {
    public static int minimizeXor(int num1, int num2) {
        // Condition 1 -> number of 1's in x == number of 1's in nums2
        // Condition 2 -> Minimize the x XOR num1
        int count1 = 0;
        // Count the number of set bits in num2 (which x can have)
        while (num2 != 0) {
            if ((num2 & 1) == 1) count1++;
            num2 >>= 1; // right shift
        }
        // To minimize the XOR value we should have as many same bit possible for both numbers
        // As 1 xor 1 or 0 xor 0 is 0, and 1 xor 0 or vice versa is 1
        // Try to match up with the MSB, remaining count1 will be added at the LSB
        int x = 0;
        for (int i=31; i>=0 && count1 > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // Is set bit ?
                x |= (1 << i); // Mark the bit as a set bit
                count1--;
            }
        }
        // If still some set bits remains to be added to x, add them to LSB
        if (count1 > 0) {
            for (int i=0; i<32 && count1 > 0; i++) {
                if ((x & (1 << i)) == 0) {
                    x |= (1 << i);
                    count1--;
                }
            }
        } return x;
    }
    public static void main(String[] args) {
        System.out.println(minimizeXor(3,5));
        System.out.println(minimizeXor(1,12));
    }
}

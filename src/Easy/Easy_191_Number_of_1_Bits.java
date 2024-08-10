// 191. Number of 1 Bits
package Easy;

public class Easy_191_Number_of_1_Bits {
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i=0; i<32; i++) {
            if ((n & 1) == 1)
                count++;
            n >>= 1;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight(00000000000000000000000010000000));
    }
}

// 3158. Find the XOR of Numbers Which Appear Twice
package Easy;

public class Easy_3158_Find_the_XOR_of_Numbers_Which_Appear_Twice {
    public static int duplicateNumbersXOR(int[] nums) {
        int[] freq = new int[51];
        for (int n : nums) freq[n]++;

        int xor = 0;
        for (int i=0; i<51; i++)
            if (freq[i] > 1)
                xor ^= i;

        return xor;
    }
    public static void main(String[] args) {
        System.out.println(duplicateNumbersXOR(new int[]{1,2,1,3}));
        System.out.println(duplicateNumbersXOR(new int[]{1,2,3}));
        System.out.println(duplicateNumbersXOR(new int[]{1,2,2,1}));
    }
}

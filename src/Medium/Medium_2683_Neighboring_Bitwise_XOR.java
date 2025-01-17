// 2683. Neighboring Bitwise XOR
package Medium;

public class Medium_2683_Neighboring_Bitwise_XOR {
    public static boolean doesValidArrayExistOpt(int[] derived) {
        // derived[i] = original[i] ⊕ original[i+1]
        // If i=n-1, then derived[i] = original[i] ⊕ original[0]
        // With these conditions, each number in derived appears 2 times in xor operation
        // a^b ^ b^c ^ c^a = 0
        // So, the xor of such operations is expected to be 0

        // If derived array is taken from a valid original array, the xor will be zero
        int xor = 0;
        for (int d : derived)
            xor ^= d;

        return xor == 0;
    }
    // Brute Force : TC -> O(n), SC -> O(n)
    public static boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] original = new int[n];
        // derived[i] = original[i] ⊕ original[i+1] -> x = y ⊕ z
        // Two possibilities -> Start with 0, start with 1
        // x⊕y = y⊕y⊕z => z = x⊕y => original[i+1] = derived[i] + original[i]

        original[0] = 0;
        for (int i=0; i<n-1; i++)
            original[i+1] = derived[i] ^ original[i];

        if ((original[0] ^ original[n-1]) == derived[n-1])
            return true;

        original[0] = 1;
        for (int i=0; i<n-1; i++)
            original[i+1] = derived[i] ^ original[i];

        if ((original[0] ^ original[n-1]) == derived[n-1])
            return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(doesValidArrayExistOpt(new int[]{1,1,0}));
        System.out.println(doesValidArrayExistOpt(new int[]{1,1}));
        System.out.println(doesValidArrayExistOpt(new int[]{1,0}));
    }
}

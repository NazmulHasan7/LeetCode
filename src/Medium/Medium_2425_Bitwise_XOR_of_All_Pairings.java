// 2425. Bitwise XOR of All Pairings
package Medium;
import java.util.HashMap;

public class Medium_2425_Bitwise_XOR_of_All_Pairings {
    // Brute Force : TC -> O(n^2), SC -> O(1)
    public static int xorAllNumsBruteForce(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int xor = 0;
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                xor ^= (nums1[i] ^ nums2[j]);

        return xor;
    }
    // TC -> O(n+m), SC -> O(n+m)
    // {a,b,c} {d,e} -> {a^d}^{b^d}^{c^d}^{a^e}^{b^e}^{c^e}
    // a ^ a = 0, a ^ 0 = a
    public static int xorAllNumsOpt(int[] nums1, int[] nums2) {
        // So, appearance of a number in even times -> a ^ a = 0
        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // In the pair, elements in num1 appear m times
        for (int num : nums1)
            map.put(num, map.getOrDefault(num,0)+m);

        // In the pair, elements in num2 appear n times
        for (int num : nums2)
            map.put(num, map.getOrDefault(num,0)+n);

        int xor = 0;
        for (int num : map.keySet()) {
            if (map.get(num) % 2 != 0)
                xor = xor ^ num;
        }
        return xor;
    }
    // TC -> O(n+m), SC -> O(1)
    public static int xorAllNums(int[] nums1, int[] nums2) {
        // So, appearance of a number in even times -> a ^ a = 0
        int n = nums1.length;
        int m = nums2.length;

        int xor = 0;
        if (n % 2 == 1) {
            // Elements in num2 will appear odd number of times
            // Remember -> Even occurrence -> a ^ a = 0
            for (int num : nums2) xor ^= num;
        }

        if (m % 2 == 1) {
            // Elements in num1 will appear odd number of times
            for (int num : nums1) xor ^= num;
        }
        return xor;
    }
    public static void main(String[] args) {
        System.out.println(xorAllNumsBruteForce(new int[]{2,1,3}, new int[]{10,2,5,0}));
        System.out.println(xorAllNumsBruteForce(new int[]{1,2}, new int[]{3,4}));
        System.out.println(xorAllNumsOpt(new int[]{2,1,3}, new int[]{10,2,5,0}));
        System.out.println(xorAllNumsOpt(new int[]{1,2}, new int[]{3,4}));
    }
}

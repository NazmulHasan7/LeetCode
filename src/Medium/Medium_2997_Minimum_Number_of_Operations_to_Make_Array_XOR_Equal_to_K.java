// 2997. Minimum Number of Operations to Make Array XOR Equal to K
package Medium;

public class Medium_2997_Minimum_Number_of_Operations_to_Make_Array_XOR_Equal_to_K {
    public static int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int x : nums)
            xor = xor ^ x;

        xor = xor ^ k; // xor of same bit -> 0, opposite bit -> 1

        // count the set bit
        int count = 0;
        while (xor != 0) {
            count += (xor & 1);
            xor >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2,1,3,4},1));
        System.out.println(minOperations(new int[]{2,0,2,0},0));
    }
}

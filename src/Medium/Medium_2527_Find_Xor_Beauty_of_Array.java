// 2527. Find Xor-Beauty of Array
package Medium;

public class Medium_2527_Find_Xor_Beauty_of_Array {
    /*
        Intuition -> for array (a,b)
        All possible triplets are ->
        ((a|a)&a) => a, ((a|a)&b) => (a&b), ((a|b)&a), ((a|b)&b)
        ((b|b)&b) => b, ((b|b)&a) => (a&b), ((b|a)&a), ((b|a)&a)
        ---------------------------------------------------------
        (a&b) ^ (a&b) => 0, ((a|b)&a) ^ ((a|b)&a) => 0 .......
        so we get => a ^ b at the end
    */
    public static int xorBeauty(int[] nums) {
        int xor = 0;
        for (int x : nums) xor = xor ^ x;
        return xor;
    }
    public static void main(String[] args) {
        System.out.println(xorBeauty(new int[]{1,4}));
        System.out.println(xorBeauty(new int[]{15,45,20,2,34,35,5,44,32,30}));
    }
}

// 2932. Maximum Strong Pair XOR I
package Easy;

public class Easy_2932_Maximum_Strong_Pair_XOR_I {
    public static int maximumStrongPairXor(int[] nums) {
        int max = 0;
        for (int i=0; i<nums.length; i++)
            for (int j=i; j<nums.length; j++)
                if (Math.abs(nums[i]-nums[j]) <= Math.min(nums[i],nums[j]))
                    max = Math.max(max, nums[i]^nums[j]);
        return max;
    }
    public static void main(String[] args) {
        System.out.println(maximumStrongPairXor(new int[]{1,2,3,4,5}));
        System.out.println(maximumStrongPairXor(new int[]{10,100}));
        System.out.println(maximumStrongPairXor(new int[]{5,6,25,30}));
    }
}

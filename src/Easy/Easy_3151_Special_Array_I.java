// 3151. Special Array I
package Easy;

public class Easy_3151_Special_Array_I {
    public static boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i=1; i<n; i++)
            if ((nums[i] & 1) == (nums[i-1] & 1))
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isArraySpecial(new int[]{1}));
        System.out.println(isArraySpecial(new int[]{2,1,4}));
        System.out.println(isArraySpecial(new int[]{4,3,1,6}));
    }
}

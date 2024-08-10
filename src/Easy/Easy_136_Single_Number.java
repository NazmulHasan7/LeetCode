// 136. Single Number
package Easy;

public class Easy_136_Single_Number {
    public static int singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i=1; i<nums.length; i++)
            xor = xor ^ nums[i];
        return xor;
    }
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,2,1}));
        System.out.println(singleNumber(new int[] {4,1,2,1,2}));
        System.out.println(singleNumber(new int[] {1}));
    }
}

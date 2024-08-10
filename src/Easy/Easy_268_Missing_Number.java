// 268. Missing Number
package Easy;

public class Easy_268_Missing_Number {
    public static int missingNumberBitXOR(int[] nums) {
        int missing = 0;
        for (int i=1; i<=nums.length; i++)
            missing ^= i;
        for (int num : nums)
            missing ^= num;
        return missing;
    }
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int n = nums.length;
        return (n * (n+1)/2) - sum;
    }
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {3,0,1}));
        System.out.println(missingNumberBitXOR(new int[] {3,0,1}));
        System.out.println(missingNumber(new int[] {0, 1}));
        System.out.println(missingNumberBitXOR(new int[] {0, 1}));
    }
}

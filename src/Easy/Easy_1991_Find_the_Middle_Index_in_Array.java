// 1991. Find the Middle Index in Array
package Easy;

public class Easy_1991_Find_the_Middle_Index_in_Array {
    public static int findMiddleIndex(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int x : nums) sum += x;

        int leftSum = 0;
        for (int i=0; i<n; i++) {
            long rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{2,3,-1,8,4}));
        System.out.println(findMiddleIndex(new int[]{1,-1,4}));
        System.out.println(findMiddleIndex(new int[]{2,5}));
    }
}

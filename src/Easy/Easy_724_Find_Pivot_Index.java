// 724. Find Pivot Index
package Easy;

public class Easy_724_Find_Pivot_Index {
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;

        int left = 0;
        for (int i=0; i<nums.length; i++) {
            sum = sum - nums[i];
            if (left == sum) return i;
            left = left + nums[i];
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[] {2,1,-1}));
    }
}

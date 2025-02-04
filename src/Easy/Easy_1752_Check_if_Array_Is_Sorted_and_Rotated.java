// 1752. Check if Array Is Sorted and Rotated
package Easy;

public class Easy_1752_Check_if_Array_Is_Sorted_and_Rotated {
    public static boolean check(int[] nums) {
        int n = nums.length;
        int countCase = 0;

        for (int i=1; i<n; i++) {
            if (nums[i] < nums[i-1]) {
                if (nums[0] < nums[n-1])
                    return false;
                countCase++;
                if (countCase > 1)
                    return false;
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(check(new int[]{3,4,5,1,2}));
        System.out.println(check(new int[]{2,1,3,4}));
        System.out.println(check(new int[]{1,2,3}));
    }
}

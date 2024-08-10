// 896. Monotonic Array
package Easy;

public class Easy_896_Monotonic_Array {
    public static boolean isMonotonic(int[] nums) {
        int i, n = nums.length;
        for (i=1; i<n; i++)
            if (nums[i-1] > nums[i]) break;
        if (i != n) {
            for (i=1; i<n; i++)
                if (nums[i-1] < nums[i])
                    return false;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[] {1,2,2,3}));
        System.out.println(isMonotonic(new int[] {6,5,4,4}));
        System.out.println(isMonotonic(new int[] {1,3,2}));
        System.out.println(isMonotonic(new int[] {1,1,2,2}));
        System.out.println(isMonotonic(new int[] {1,1,0}));
    }
}

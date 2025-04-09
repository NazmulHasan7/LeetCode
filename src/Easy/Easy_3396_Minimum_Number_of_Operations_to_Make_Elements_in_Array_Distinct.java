// 3396. Minimum Number of Operations to Make Elements in Array Distinct
package Easy;

import java.util.HashSet;

public class Easy_3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct {
    public static int minimumOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int i=0; i<n; i+=3) {
            if (isUnique(nums, i))
                return operations;
            operations++;
        }
        return operations;
    }
    private static boolean isUnique(int[] arr, int start) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=start; i<arr.length; i++) {
            if (set.contains(arr[i]))
                return false;
            set.add(arr[i]);
        }
        return true;
    }
    // Optimal approach
    public static int minimumOperationsOpt(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[100];

        int operations = 0;
        // no of elements = (i+1)
        // no of group of 3 = (i+1)/3
        // no of operations = no of group of 3
        for (int i=n-1; i>=0; i--) {
            if (seen[nums[i]])
                return (int)Math.ceil((i+1)/3.0);
            seen[nums[i]] = true;
        }
        return operations;
    }
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1,2,3,4,2,3,3,5,7}));
        System.out.println(minimumOperations(new int[]{4,5,6,4,4}));
        System.out.println(minimumOperationsOpt(new int[]{1,2,3,4,2,3,3,5,7}));
        System.out.println(minimumOperationsOpt(new int[]{4,5,6,4,4}));
    }
}

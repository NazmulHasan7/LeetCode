// 3190. Find Minimum Operations to Make All Elements Divisible by Three
package Easy;

public class Easy_3190_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three {
    public static int minimumOperations(int[] nums) {
        int count = 0;
        for (int x : nums)
            if (x % 3 != 0) count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1,2,3,4}));
        System.out.println(minimumOperations(new int[]{3,6,9}));
    }
}

// 1558. Minimum Numbers of Function Calls to Make Target Array
package Medium;

public class Medium_1558_Minimum_Numbers_of_Function_Calls_to_Make_Target_Array {
    public static int minOperations(int[] nums) {
        int ops = 0, maxShifts = 0;
        for (int n : nums) {
            int shifts = 0;
            while (n > 0) {
                if ((n & 1) == 0) {
                    shifts++;
                    n >>= 1;
                } else {
                    n--;
                    ops++;
                }
            }
            maxShifts = Math.max(maxShifts, shifts);
        }
        return ops + maxShifts;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,5}));
        System.out.println(minOperations(new int[]{2,2}));
        System.out.println(minOperations(new int[]{4,2,5}));
    }
}

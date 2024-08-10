// 3065. Minimum Operations to Exceed Threshold Value I
package Easy;

public class Easy_3065_Minimum_Operations_to_Exceed_Threshold_Value_I {
    public static int minOperations(int[] nums, int k) {
        int minOps = 0;
        for (int num : nums)
            if (num < k) minOps++;
        return minOps;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {2,11,10,1,3}, 10));
        System.out.println(minOperations(new int[] {1,1,2,4,9}, 1));
        System.out.println(minOperations(new int[] {1,1,2,4,9}, 9));
    }
}

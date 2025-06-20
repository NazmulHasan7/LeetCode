// 2294. Partition Array Such That Maximum Difference Is K
package Medium;

import java.util.Arrays;

public class Medium_2294_Partition_Array_Such_That_Maximum_Difference_Is_K {
    public static int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int partitions = 0;

        for (int i=0; i<n; ) {
            int j = i+1;
            while (j<n && nums[j] - nums[i] <= k)
                j++;
            partitions++;
            i = j;
        }
        return partitions;
    }
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{3,6,1,2,5},2));
        System.out.println(partitionArray(new int[]{1,2,3}, 1));
        System.out.println(partitionArray(new int[]{2,2,4,5}, 0));
    }
}

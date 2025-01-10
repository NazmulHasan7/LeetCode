// 915. Partition Array into Disjoint Intervals
package Medium;

public class Medium_915_Partition_Array_into_Disjoint_Intervals {
    public static int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int index = 0;
        int possibleLeftMax = nums[0];
        int currentMax = nums[0];

        for (int i=1; i<n-1; i++) {
            if (nums[i] < possibleLeftMax) {
                index = i;
                possibleLeftMax = currentMax;
            }
            currentMax = Math.max(currentMax, nums[i]);
        }
        return index + 1;
    }
    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println(partitionDisjoint(new int[]{1,1,1,0,6,12}));
    }
}

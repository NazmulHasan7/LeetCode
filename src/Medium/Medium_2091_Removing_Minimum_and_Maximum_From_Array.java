// 2091. Removing Minimum and Maximum From Array
package Medium;

public class Medium_2091_Removing_Minimum_and_Maximum_From_Array {
    public static int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = 0, maxIdx = 0;

        for (int i=0; i<n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        int removeFromFront = Math.max(minIdx+1, maxIdx+1);
        int removeFromEnd = Math.max(n-minIdx, n-maxIdx);
        int removeFromBoth = Math.min(minIdx+1, n-minIdx) + Math.min(maxIdx+1, n-maxIdx);
        return Math.min(removeFromBoth, Math.min(removeFromFront, removeFromEnd));
    }
    public static void main(String[] args) {
        System.out.println(minimumDeletions(new int[]{2,10,7,5,4,1,8,6}));
        System.out.println(minimumDeletions(new int[]{0,-4,19,1,8,-2,-3,5}));
        System.out.println(minimumDeletions(new int[]{101}));
    }
}

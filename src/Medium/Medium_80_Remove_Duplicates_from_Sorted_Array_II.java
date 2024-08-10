// 80. Remove Duplicates from Sorted Array II
package Medium;

public class Medium_80_Remove_Duplicates_from_Sorted_Array_II {
    public static int removeDuplicates(int[] nums) {
        int left = 2, right = 2;
        while (left < nums.length) {
            if (nums[left] != nums[right-2])
                nums[right++] = nums[left];
            left++;
        } return right;
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,1,2,2,3}));
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3}));
    }
}

// 26. Remove Duplicates from Sorted Array
package Easy;

public class Easy_26_Remove_Duplicates_from_Sorted_Array {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int k = 1;
        for (int i=0; i<length-1; i++) {
            if (nums[i] == nums[i+1])
                nums[k++] = nums[i+1];
        } return k;
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[] {1,1,2}));
    }
}

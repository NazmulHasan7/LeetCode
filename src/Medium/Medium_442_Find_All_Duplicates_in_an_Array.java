// 442. Find All Duplicates in an Array
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_442_Find_All_Duplicates_in_an_Array {
    public static List<Integer> findDuplicatesSorting(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length-1; i++)
            if (nums[i] == nums[i+1]) list.add(nums[i]);
        return list;
    }
    public static List<Integer> findDuplicatesFreq(int[] nums) {
        int[] freq = new int[nums.length+1];
        for (int num : nums)
            freq[num]++;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<=nums.length; i++)
            if (freq[i] == 2) list.add(i);
        return list;
    }
    public static List<Integer> findDuplicates(int[] nums) {
        // The values 1<=arr[i]<=n | where arr[i]-1 is a valid index in the array
        List<Integer> result = new ArrayList<>();
        int index;
        for (int i=0; i<nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            // Negative value means the index is already visited
            if (nums[index] < 0) result.add(index+1);
            // Make the value at index negative
            nums[index] = -nums[index];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(findDuplicatesFreq(arr).toArray()));
    }
}

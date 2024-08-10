// 287. Find the Duplicate Number
package Medium;
import java.util.Arrays;
import java.util.HashSet;

public class Medium_287_Find_the_Duplicate_Number {
    // Brute Force Approach -> Time O(n^2) Space O(1)
    public static int findDuplicateBruteforce(int[] nums) {
        for (int i=0; i<nums.length; i++)
            for (int j=i+1; j<nums.length; j++)
                if (nums[i] == nums[j]) return nums[i];
        return -1;
    }
    // Sorting Approach -> Time O(nlogn) Space O(1)
    public static int findDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++)
            if (nums[i] == nums[i+1]) return nums[i];
        return -1;
    }
    // HashSet Approach -> Time O(n) Space O(n)
    public static int findDuplicateHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            if (!set.add(num)) return num;
        return -1;
    }
    // Frequency Array Approach -> Time O(n) Space O(n)
    public static int findDuplicateFrequency(int[] nums) {
        int[] freq = new int[nums.length];
        for (int num : nums)
            freq[num]++;
        for (int i=0; i<freq.length; i++)
            if (freq[i] > 1) return i;
        return -1;
    }
    // Boolean Array Approach -> Time O(n) Space O(n)
    public static int findDuplicateBoolean(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for (int num : nums) {
            if (arr[num]) return num;
            arr[num] = true;
        } return -1;
    }
    // Floyd's Cycle Detection - Hare Tortoise Algorithm -> Time O(n) Space O(1)
    // Reference: https://www.youtube.com/watch?v=wjYnzkAhcNk
    public static int findDuplicate(int[] nums) {
        // Consider the problem as a linked list problem
        // Length = n +1 and nums[i] in 1 to n
        // Same problem as finding the start node of a LinkedList cycle
        int slow = nums[0], fast = nums[0];

        // Find if a cycle exist
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Find the start of the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        } return slow;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicateBruteforce(arr));
        System.out.println(findDuplicateSorting(arr));
        System.out.println(findDuplicateHashSet(arr));
        System.out.println(findDuplicateFrequency(arr));
        System.out.println(findDuplicate(arr));
    }
}

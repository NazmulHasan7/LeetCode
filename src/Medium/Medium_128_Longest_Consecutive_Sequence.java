// 128. Longest Consecutive Sequence
package Medium;
import java.util.Arrays;
import java.util.HashSet;

public class Medium_128_Longest_Consecutive_Sequence {
    // Sorting the array -> O(nlogn)
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int longest = 0, count = 1;
        Arrays.sort(nums);

        int num1 = nums[0];
        for (int num2 : nums) {
            if (num1+1 == num2) {
                num1++;
                count++;
            } else if (num1 != num2) {
                longest = Math.max(longest, count);
                count = 1;
                num1 = num2;
            }
        } longest = Math.max(longest, count);
        return longest;
    }
    // Using HashMap -> O(n)
    public static int longestConsecutiveHashMap(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int count = 1, longest = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                // Start of the sequence
                int x = num;
                count = 1;
                while (set.contains(x+1)) {
                    x++;
                    count++;
                } longest = Math.max(longest, count);
            }
        } return longest;
    }
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[] {0,1,2}));
        System.out.println(longestConsecutive(new int[] {0}));
        System.out.println(longestConsecutive(new int[] {0,0}));
        System.out.println(longestConsecutive(new int[] {}));
    }
}

// 3434. Maximum Frequency After Subarray Operation
package Medium;
import java.util.HashSet;

public class Medium_3434_Maximum_Frequency_After_Subarray_Operation {
    public static int maxFrequency(int[] nums, int k) {
        int kFreq = 0;
        int maxFreq = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num == k) kFreq++;
            set.add(num);
        }

        // For each unique number in nums, use kadane's algorithm
        for (int i : set) {
            if (i != k) {
                int currFreq = 0;
                for (int num : nums) {
                    if (num == k) {
                        currFreq--; // adding x to k will be another number
                        if (currFreq < 0)
                            currFreq = 0;
                    } else if (i == num) {
                        currFreq++; // adding k-num will give us k
                    }
                    maxFreq = Math.max(currFreq, maxFreq);
                }
            }
        } return kFreq + maxFreq;
    }
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1,2,3,4,5,6},1));
        System.out.println(maxFrequency(new int[]{10,2,3,4,5,5,4,3,2,2},10));
        System.out.println(maxFrequency(new int[]{1,9},8));
    }
}

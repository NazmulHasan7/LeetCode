// 398. Random Pick Index
package Medium;
import java.util.Random;

public class Medium_398_Random_Pick_Index {
    static class Solution {
        int[] arr;
        public Solution(int[] nums) {
            arr = nums;
        }
        public int pick(int target) {
            int count = 0;
            int pickedIndex = 0;
            Random random = new Random();
            for (int i=0; i<arr.length; i++) {
                // Count the number of matches found
                if (arr[i] == target) {
                    count++;
                    // Favorable outcome 1/count
                    if (random.nextInt(count) == count-1)
                        pickedIndex = i;
                }
            } return pickedIndex;
        }
        public int pickBetter(int target) {
            Random random = new Random();
            while (true) {
                int index = random.nextInt(arr.length);
                if (arr[index] == target)
                    return index;
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution(new int[] {1, 2, 3, 3, 3});
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(3));
    }
}

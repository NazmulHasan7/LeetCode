// 485. Max Consecutive Ones
package Easy;

public class Easy_485_Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(count, max);
                count = 0;
            } else count++;
        } return Math.max(count, max);
    }
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
    }
}

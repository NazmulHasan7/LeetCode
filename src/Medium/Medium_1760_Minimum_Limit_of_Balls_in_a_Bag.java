// 1760. Minimum Limit of Balls in a Bag
package Medium;

public class Medium_1760_Minimum_Limit_of_Balls_in_a_Bag {
    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;
        for (int num : nums)
            right = Math.max(right, num);

        int answer = 0;
        while (left <= right) {
            int maxBalls = left + (right - left) / 2;
            if (isPossible(nums, maxBalls, maxOperations)) {
                answer = maxBalls;
                right = maxBalls - 1;
            } else {
                left = maxBalls + 1;
            }
        } return answer;
    }
    private static boolean isPossible(int[] arr, int maxBalls, int maxOps) {
        int operations = 0;
        for (int balls : arr) {
            operations += (int)(Math.ceil(balls / (double)maxBalls)) - 1;
            if (operations > maxOps)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{9}, 2));
        System.out.println(minimumSize(new int[]{2,4,8,2}, 4));
    }
}

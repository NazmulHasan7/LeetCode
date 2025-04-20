// 1283. Find the Smallest Divisor Given a Threshold
package Medium;

public class Medium_1283_Find_the_Smallest_Divisor_Given_a_Threshold {
    // TC -> O(n * log(max)) SC -> O(1)
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        for (int num : nums)
            high = Math.max(high, num);

        int answer = -1;
        while (low <= high) {
            int divisor = low + (high - low) / 2;
            if (isValid(nums, divisor, threshold)) {
                answer = divisor;
                high = divisor - 1;
            } else {
                low = divisor + 1;
            }
        } return answer;
    }
    private static boolean isValid(int[] arr, int divisor, int threshold) {
        int sum = 0;
        for (int num : arr) {
            // sum += (int) Math.ceil((double) num / divisor);
            sum += (num + divisor - 1) / divisor;
            if (sum > threshold)
                return false;
        }
        return sum <= threshold;
    }
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{1,2,5,9},6));
        System.out.println(smallestDivisor(new int[]{44,22,33,11,1},5));
    }
}

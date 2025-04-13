// 3153. Sum of Digit Differences of All Pairs
package Medium;

public class Medium_3153_Sum_of_Digit_Differences_of_All_Pairs {
    public static long sumDigitDifferences(int[] nums) {
        long answer = 0;
        int n = nums.length;

        while (nums[0] != 0) {
            int[] count = new int[10];
            for (int i=0; i<n; i++) {
                int dig = nums[i] % 10;
                count[dig]++;
                nums[i] /= 10;
            }

            for (int c : count)
                answer += (long) c * (n-c);
        }
        return answer / 2; // pair
    }
    public static void main(String[] args) {
        System.out.println(sumDigitDifferences(new int[]{13,23,12}));
        System.out.println(sumDigitDifferences(new int[]{10,10,10,10}));
    }
}

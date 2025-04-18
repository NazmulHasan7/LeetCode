// 1664. Ways to Make a Fair Array
package Medium;

public class Medium_1664_Ways_to_Make_a_Fair_Array {
    public static int waysToMakeFair(int[] nums) {
        long evenSum = 0, oddSum = 0;
        int n = nums.length;
        long[] evenSumPref = new long[n];
        long[] oddSumPref = new long[n];

        for (int i=0; i<n; i++) {
            if ((i&1) == 0) evenSum += nums[i];
            else oddSum += nums[i];
            evenSumPref[i] = evenSum;
            oddSumPref[i] = oddSum;
        }

        int count = 0;
        // we can remove only one element to make the array fair
        // so, we try to remove each index and check if the array is fair or not
        for (int i=0; i<n; i++) {
            long updatedEvenSum, updatedOddSum;
            if ((i&1) == 0) { // even index <- consider removing it
                // since the indices moves, even indices becomes odd indices and vice versa now
                // updatedEvenSum = even sum till prev index + remaining odd sum
                updatedEvenSum = ((i-1) >= 0 ? evenSumPref[i-1] : 0) + (oddSum - oddSumPref[i]);
                updatedOddSum = oddSumPref[i] + (evenSum - evenSumPref[i]);
            } else { // odd index
                // updatedEvenSum = odd sum till prev index + remaining even sum
                updatedOddSum = oddSumPref[i-1] + (evenSum - evenSumPref[i]);
                updatedEvenSum = evenSumPref[i] + (oddSum - oddSumPref[i]);
            }
            // System.out.println("Up EVEN " + updatedEvenSum + " Up ODD " + updatedOddSum);
            if (updatedOddSum == updatedEvenSum)
                count++;
        }
        return count;
    }
    // Space Optimization
    public int waysToMakeFairOpt(int[] nums) {
        int n = nums.length;
        int rightEvenSum = 0, rightOddSum = 0;

        for (int i = 0; i < n; i += 2)
            rightEvenSum += nums[i];

        for (int i = 1; i < n; i += 2)
            rightOddSum += nums[i];

        int leftEvenSum = 0, leftOddSum = 0;

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (i % 2 == 0) rightEvenSum -= num;
            else rightOddSum -= num;

            if (leftOddSum + rightEvenSum == leftEvenSum + rightOddSum)
                count++;

            if (i % 2 == 0) leftEvenSum += num;
            else leftOddSum += num;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println(waysToMakeFair(new int[]{1,1,1}));
        System.out.println(waysToMakeFair(new int[]{1,2,3}));
    }
}

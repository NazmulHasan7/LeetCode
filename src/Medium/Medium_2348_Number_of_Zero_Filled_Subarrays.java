// 2348. Number of Zero-Filled Subarrays
package Medium;

public class Medium_2348_Number_of_Zero_Filled_Subarrays {
    public static long zeroFilledSubarray(int[] nums) {
        // There are n*(n+1)/2 sub-arrays possible for an array of length n
        long answer = 0;
        int n = 0;
        for (int num : nums) {
            if (num == 0) {
                n++;
            } else {
                if (n > 0)
                    answer += ((long) n*(n+1)/2);
                n = 0;
            }
        }
        if (n > 0)
            answer += ((long) n*(n+1)/2);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
        System.out.println(zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
        System.out.println(zeroFilledSubarray(new int[]{2,10,2019}));
    }
}

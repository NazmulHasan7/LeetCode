// 2110. Number of Smooth Descent Periods of a Stock
package Medium;

public class Medium_2110_Number_of_Smooth_Descent_Periods_of_a_Stock {
    public static long getDescentPeriods(int[] prices) {
        int prev = -100;
        int count = 0;
        long answer = 0;

        for (int p : prices) {
            if (prev - 1 == p) {
                count++;
            } else {
                answer += ((long) count * (count + 1)/2); // number of sub-arrays
                count = 1;
            }
            prev = p;
        }
        answer += ((long) count * (count + 1)/2);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(getDescentPeriods(new int[]{3,2,1,4}));
        System.out.println(getDescentPeriods(new int[]{8,6,7,7}));
        System.out.println(getDescentPeriods(new int[]{1}));
    }
}

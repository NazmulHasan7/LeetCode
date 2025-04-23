// 3185. Count Pairs That Form a Complete Day II
package Medium;

public class Medium_3185_Count_Pairs_That_Form_a_Complete_Day_II {
    public static long countCompleteDayPairs(int[] hours) {
        long completeDays = 0;
        int[] freq = new int[24];

        for (int hour : hours) {
            int extraHour = hour % 24;
            if (extraHour == 0)
                completeDays += freq[0];
            else completeDays += freq[24-extraHour];
            freq[extraHour]++;
        }
        return completeDays;
    }
    public static void main(String[] args) {
        System.out.println(countCompleteDayPairs(new int[]{12,12,30,24,24}));
        System.out.println(countCompleteDayPairs(new int[]{72,48,24,3}));
    }
}

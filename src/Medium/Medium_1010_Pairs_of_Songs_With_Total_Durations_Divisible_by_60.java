// 1010. Pairs of Songs With Total Durations Divisible by 60
package Medium;

public class Medium_1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public static int numPairsDivisibleBy60(int[] time) {
        int[] freq = new int[60];
        int pairCount = 0;

        for (int t : time) {
            int extraTime = t % 60;
            if (extraTime == 0) {
                pairCount += freq[0];
            } else pairCount += freq[60-extraTime];
            freq[extraTime]++;
        }
        return pairCount;
    }
    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        System.out.println(numPairsDivisibleBy60(new int[]{60,60,60}));
    }
}

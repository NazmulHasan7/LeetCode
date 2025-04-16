// 2275. Largest Combination With Bitwise AND Greater Than Zero
package Medium;

public class Medium_2275_Largest_Combination_With_Bitwise_AND_Greater_Than_Zero {
    public static int largestCombination(int[] candidates) {
        // answer should be maximum frequency of a set bit
        int[] setBitFreq = new int[31];

        for (int number : candidates) {
            for (int i=0; i<31; i++) {
                boolean setBit = (number & 1) == 1;
                if (setBit) setBitFreq[i]++;
                number >>= 1;
            }
        }

        int answer = 0;
        for (int i=0; i<31; i++)
            answer = Math.max(answer, setBitFreq[i]);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(largestCombination(new int[]{16,17,71,62,12,24,14}));
        System.out.println(largestCombination(new int[]{8,8}));
    }
}

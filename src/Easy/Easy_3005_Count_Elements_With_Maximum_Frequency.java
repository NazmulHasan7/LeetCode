// 3005. Count Elements With Maximum Frequency
package Easy;

public class Easy_3005_Count_Elements_With_Maximum_Frequency {
    public static int maxFrequencyElements(int[] nums) {
        int[] frequency = new int[101];
        for (int num : nums) frequency[num]++;

        int maxFreq = 0, maxCount = 0;
        for (int i=0; i<frequency.length; i++) {
            if (frequency[i] > maxFreq)
                maxCount = maxFreq = frequency[i];
            else if (frequency[i] == maxFreq)
                maxCount += frequency[i];
        } return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[] {1,2,2,3,1,4}));
    }
}

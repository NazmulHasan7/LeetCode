// 3663. Find The Least Frequent Digit
package Easy;

public class Easy_3663_Find_The_Least_Frequent_Digit {
    public static int getLeastFrequentDigit(int n) {
        int[] freq = new int[10];
        while (n != 0) {
            freq[n % 10]++;
            n /= 10;
        }

        int minFreq = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 0; i < 10; i++) {
            if (freq[i] != 0 && freq[i] < minFreq) {
                minFreq = freq[i];
                answer = i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(getLeastFrequentDigit(1553322));
        System.out.println(getLeastFrequentDigit(723344511));
    }
}

// 2094. Finding 3-Digit Even Numbers
package Easy;
import java.util.*;

public class Easy_2094_Finding_3_Digit_Even_Numbers {
    // 3 digits number and cannot start with 0 -> range [100, 999]
    // Brute Force Approach -> O(n^3)
    public static int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    // cannot use the same index digit more than once
                    if (i == j || j == k || i == k)
                        continue;

                    int number = digits[i]*100 + digits[j]*10 + digits[k];
                    if (number >= 100 && (number & 1) == 0)
                        set.add(number);
                }
            }
        }
        List<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);

        int[] arr = new int[answer.size()];
        for (int i=0; i<arr.length; i++)
            arr[i] = answer.get(i);
        return arr;
    }

    // Optimized Approach
    public static int[] findEvenNumbersOpt(int[] digits) {
        int[] digFreq = new int[10];
        for (int d : digits) digFreq[d]++;

        List<Integer> arr = new ArrayList<>();

        for (int number = 100; number < 1000; number += 2) {
            int[] numFreq = new int[10];
            int temp = number;

            while (temp != 0) {
                numFreq[temp % 10]++;
                temp /= 10;
            }

            boolean valid = true;

            for (int i=0; i<10; i++)
                if (digFreq[i] < numFreq[i])
                    valid = false;

            if (valid) arr.add(number);
        }

        Collections.sort(arr);
        int[] answer = new int[arr.size()];
        for (int i=0; i<answer.length; i++)
            answer[i] = arr.get(i);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2,1,3,0})));
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2,2,8,8,2})));
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{3,7,5})));
    }
}

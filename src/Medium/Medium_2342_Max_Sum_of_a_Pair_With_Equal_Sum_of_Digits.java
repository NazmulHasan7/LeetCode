// 2342. Max Sum of a Pair With Equal Sum of Digits
package Medium;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Medium_2342_Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits {
    // TC -> O(n * log(n)), SC -> O(n)
    public static int maximumSum(int[] nums) {
        // Sorted map and max heap (descending order)
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>((a, b) -> b-a);

        // Group numbers by the sum of their digits -> O(n * log(n))
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            map.computeIfAbsent(digitSum,
                    k -> new PriorityQueue<>((a,b) -> b-a)
            ).add(num);
        }

        int answer = -1;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() > 1) {
                int n1 = pq.poll();
                int n2 = pq.poll();
                answer = Math.max(n1 + n2, answer);
            }
        } return answer;
    }
    private static int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Optimized Approach O(n * log(max_num))
    public static int maximumSumOpt(int[] nums) {
        // Max range of num[i] = 10^9
        // Maximum possible number 9999999999 => sum = 90
        int[] storage = new int[100];
        int answer = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (storage[digitSum] != 0) {
                answer = Math.max(answer, storage[digitSum] + num);
                storage[digitSum] = Math.max(storage[digitSum], num);
            } else {
                storage[digitSum] = num;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18,43,36,13,7}));
        System.out.println(maximumSum(new int[]{10,12,19,14}));
    }
}

// 1399. Count Largest Group
package Easy;

public class Easy_1399_Count_Largest_Group {
    // TC -> O(n * log(avg size of number) SC -> O(n) [worst case]
    public static int countLargestGroup(int n) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        int[] map = new int[40];
        for (int i=1; i<=n; i++) {
            int sum = digitSum(i);
            // map.put(sum, map.getOrDefault(sum, 0) + 1);
            map[sum]++;
        }

        int maxSize = 0;
        int count = 0;
        // for (int size : map.values()) {
        for (int size : map) {
            if (size > maxSize) {
                maxSize = size;
                count = 1;
            } else if (size == maxSize) {
                count++;
            }
        } return count;
    }
    private static int digitSum (int number) {
        int sum = 0;
        while (number != 0) {
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
        System.out.println(countLargestGroup(2));
    }
}

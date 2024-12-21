// 1742. Maximum Number of Balls in a Box
package Easy;

public class Easy_1742_Maximum_Number_of_Balls_in_a_Box {
    private static int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
    public static int countBalls(int lowLimit, int highLimit) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int [] count = new int[46];
        for (int i=lowLimit; i<=highLimit; i++) {
            int sum = digitSum(i);
            // map.put(sum, map.getOrDefault(sum,0) + 1);
            // maxCount = Math.max(maxCount, map.get(sum));
            maxCount = Math.max(maxCount, ++count[sum]);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(countBalls(1,10));
        System.out.println(countBalls(5,15));
        System.out.println(countBalls(19,28));
    }
}

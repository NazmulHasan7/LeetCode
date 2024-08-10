// 633. Sum of Square Numbers
package Medium;

public class Medium_633_Sum_of_Square_Numbers {
    public static boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int) Math.sqrt(c);
        while (start <= end) {
            long answer = (long)start*start + (long)end*end;
            if (answer == c) return true;
            else if (answer < c) start++;
            else end--;
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(2147483600));
    }
}

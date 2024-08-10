// 2177. Find Three Consecutive Integers That Sum to a Given Number
package Medium;
import java.util.Arrays;

public class Medium_2177_Find_Three_Consecutive_Integers_That_Sum_to_a_Given_Number {
    public static long[] sumOfThree(long num) {
        // x-1 + x + x+1 = num => x = num / 3
        if (num % 3 != 0) return new long[] {};
        long mid = num / 3;
        return new long[] {mid-1, mid, mid+1};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfThree(33)));
        System.out.println(Arrays.toString(sumOfThree(4)));
        System.out.println(Arrays.toString(sumOfThree(5484)));
    }
}

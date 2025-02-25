// 2829. Determine the Minimum Sum of a k-avoiding Array
package Medium;
import java.util.HashSet;

public class Medium_2829_Determine_the_Minimum_Sum_of_a_k_avoiding_Array {
    public static int minimumSum(int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int number = 1;
        while (n > 0) {
            if (number < k) {
                if (!set.contains(k - number)) {
                    set.add(number);
                    sum += number;
                    n--;
                }
            } else {
                if (!set.contains(number + k)) {
                    set.add(number);
                    sum += number;
                    n--;
                }
            } number++;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(minimumSum(5,4));
        System.out.println(minimumSum(2,6));
    }
}

// 1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
package Medium;
import java.util.ArrayList;

public class Medium_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K {
    // TC & SC -> O(log(k))
    public static int findMinFibonacciNumbers(int k) {
        if (k == 1) return 1;

        ArrayList<Integer> numbers = new ArrayList<>();
        int first = 1, second = 1;
        int fibNum = first + second;

        while (fibNum <= k) {
            numbers.add(fibNum);
            first = second;
            second = fibNum;
            fibNum = first + second;
        }

        int count = 0;
        for (int i=numbers.size()-1; i>=0; i--) {
            if (k >= numbers.get(i)) {
                k -= numbers.get(i);
                count++;
                if (k == 1) return count + 1;
                else if (k == 0) return count;
            }
        }
        return -1;
    }
    // Memory Optimization
    public static int findMinFibonacciNumbersMemOpt(int k) {
        if (k < 2) return k;
        int count = 0;

        while (k > 0) {
            int first = 1;
            int second = 1;
            int fibNum = first + second;
            while (fibNum <= k) {
                first = second;
                second = fibNum;
                fibNum = first + second;
            }
            count++;
            k -= second; // Last valid fibNum
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(7));
        System.out.println(findMinFibonacciNumbers(10));
        System.out.println(findMinFibonacciNumbers(19));
        System.out.println(findMinFibonacciNumbers(2));
    }
}

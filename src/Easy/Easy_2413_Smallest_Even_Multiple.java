// 2413. Smallest Even Multiple
package Easy;

public class Easy_2413_Smallest_Even_Multiple {
    public static int smallestEvenMultiple(int n) {
        return (n % 2 == 0) ? n : n * 2;
    }
    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(5));
        System.out.println(smallestEvenMultiple(6));
    }
}

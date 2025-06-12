// 2571. Minimum Operations to Reduce an Integer to 0
package Medium;

public class Medium_2571_Minimum_Operations_to_Reduce_an_Integer_to_0 {
    // 39 -> 1 0 0 1 1 1 0 -> for consecutive 1's more than 1 time
    // add 1 -> 1 1 1 + 1 -> 1 0 0 0 -> convert it into some 2^x
    // another operation to subtract
    public static int minOperations(int n) {
        int operations = 0;
        int consecutive1 = 0;

        while (n > 0) {
            int bit = n & 1;

            if (bit == 1) {
                consecutive1++;
                n >>= 1;
            } else {
                if (consecutive1 > 1) {
                    n += 1; // add to make 011 to 100
                    operations++;
                    consecutive1 = 0;
                } else if (consecutive1 == 1) {
                    operations++;
                    consecutive1 = 0;
                    n >>= 1;
                } else { // only 0
                    n >>= 1;
                }
            }
        }
        if (consecutive1 > 1)
            operations += 2;
        else if (consecutive1 == 1)
            operations++;
        return operations;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(39));
        System.out.println(minOperations(54));
    }
}

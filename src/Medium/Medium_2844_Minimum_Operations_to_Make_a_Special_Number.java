// 2844. Minimum Operations to Make a Special Number
package Medium;

public class Medium_2844_Minimum_Operations_to_Make_a_Special_Number {
    // TC -> O(4N) => O(N)
    public static int minimumOperations(String num) {
        if (num.equals("0")) return 0;

        // numbers ending with 00, 25, 50, 75 are divisible by 25
        char[] numArr = num.toCharArray();
        int n = num.length();
        int operations = Integer.MAX_VALUE;
        boolean zeroFound = false;

        for (int last = n-1; last >= 1; last--) {
            int lastDigit = numArr[last] - '0';

            if (lastDigit == 0) {
                zeroFound = true;

                for (int secLast = last-1; secLast >= 0; secLast--) {
                    int secondLastDigit = numArr[secLast] - '0';
                    if (secondLastDigit == 0 || secondLastDigit == 5) {
                        operations = Math.min(operations, (n-1-last) + (last-secLast-1));
                        break;
                    }
                }
            } else if (lastDigit == 5) {
                for (int secLast = last-1; secLast >= 0; secLast--) {
                    int secondLastDigit = numArr[secLast] - '0';
                    if (secondLastDigit == 2 || secondLastDigit == 7) {
                        operations = Math.min(operations, (n-1-last) + (last-secLast-1));
                        break;
                    }
                }
            }
        }
        if (operations == Integer.MAX_VALUE)
            return zeroFound ? n-1 : n; // keep the 0 only or delete all
        return operations;
    }
    public static void main(String[] args) {
        System.out.println(minimumOperations("2245047"));
        System.out.println(minimumOperations("2908305"));
        System.out.println(minimumOperations("10"));
    }
}

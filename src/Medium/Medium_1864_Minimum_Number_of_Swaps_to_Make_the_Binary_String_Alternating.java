// 1864. Minimum Number of Swaps to Make the Binary String Alternating
package Medium;

public class Medium_1864_Minimum_Number_of_Swaps_to_Make_the_Binary_String_Alternating {
    public static int minSwaps(String s) {
        char[] crr = s.toCharArray();
        int ones = 0, zeros = 0;

        for (char c : crr) {
            if (c == '0') zeros++;
            else ones++;
        }
        // invalid case
        if (Math.abs(zeros - ones) > 1) return -1;
        if (ones > zeros) // cases like 110 -> 101
            return countSwap(crr, '1');
        else if (zeros > ones) // cases like 100 -> 010
            return countSwap(crr, '0');
        return Math.min(countSwap(crr, '0'), countSwap(crr, '1'));
    }
    private static int countSwap(char[] crr, char d) {
        int count = 0;
        for (char c : crr) {
            if (c != d) count++;
            d = (d == '1') ? '0' : '1';
        }
        return count / 2;
    }
    public static void main(String[] args) {
        System.out.println(minSwaps("111000"));
        System.out.println(minSwaps("010"));
        System.out.println(minSwaps("1110"));
    }
}

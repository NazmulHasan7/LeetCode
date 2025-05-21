// 306. Additive Number
package Medium;

public class Medium_306_Additive_Number {
    public static boolean isAdditiveNumber(String num) {
        return backtrack(0, -1, -1, 0, num.toCharArray(), num.length());
    }
    private static boolean backtrack(int start, long prev1, long prev2, int count, char[] num, int size) {
        if (start >= size)
            return count >= 3; // minimum length should be 3

        long currentNumber = 0;

        for (int i=start; i<size; i++) {
            // cannot start with 0
            if (num[start] == '0' && i > start)
                return false;

            currentNumber = currentNumber * 10 + (num[i] - '0');
            if (prev1 == -1) {
                if (backtrack(i+1, currentNumber, prev2, count+1, num, size))
                    return true;
            } else if (prev2 == -1) {
                if (backtrack(i+1, prev1, currentNumber, count+1, num, size))
                    return true;
            } else {
                if (prev1 + prev2 < currentNumber) break;
                    // prev1 + prev2 > currentNumber -> keep expanding the number to make it bigger
                else if (prev1 + prev2 > currentNumber) continue;
                else // prev1 + prev2 == currentNumber
                    if (backtrack(i+1, prev2, currentNumber, count+1, num, size))
                        return true;
            }
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("112358"));
        System.out.println(isAdditiveNumber("199100199"));
    }
}

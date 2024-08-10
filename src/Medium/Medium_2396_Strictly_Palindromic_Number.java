// 2396. Strictly Palindromic Number
package Medium;

public class Medium_2396_Strictly_Palindromic_Number {
    public static StringBuilder convertToBaseInReverse(int num, int base) {
        StringBuilder sb = new StringBuilder();
        int rem;
        while (num != 0) {
            rem = num % base;
            sb.append(rem);
            num = num / base;
        } return sb;
    }
    public static boolean isStrictlyPalindromic(int n) {
        for (int base=2; base<=n-2; base++) {
            StringBuilder basedNum = convertToBaseInReverse(n, base);
            if (!basedNum.toString().contentEquals(basedNum.reverse()))
                return false;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(isStrictlyPalindromic(9));
    }
}

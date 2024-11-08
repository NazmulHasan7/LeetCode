// 3340. Check Balanced String
package Easy;

public class Easy_3340_Check_Balanced_String {
    public static boolean isBalanced(String num) {
        int sumEven = 0, sumOdd = 0;
        int n = num.length();

        for (int i=0; i<n; i++) {
            if ((i&1) == 1)
                sumOdd += num.charAt(i) - '0';
            else
                sumEven += num.charAt(i) - '0';
        }
        return sumOdd == sumEven;
    }
    public static void main(String[] args) {
        System.out.println(isBalanced("1234"));
        System.out.println(isBalanced("24123"));
    }
}

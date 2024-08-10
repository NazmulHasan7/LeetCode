// 2864. Maximum Odd Binary Number
package Easy;
import java.util.Arrays;

public class Easy_2864_Maximum_Odd_Binary_Number {
    public static String maximumOddBinaryNumber(String s) {
        int countBit = 0;
        char[] cArr = s.toCharArray();
        int length = cArr.length;
        for (char c : cArr)
            if (c == '1') countBit++;
        if (countBit == 1) {
            Arrays.fill(cArr, 0, length - 1, '0');
        } else {
            Arrays.fill(cArr, 0, countBit-1, '1');
            Arrays.fill(cArr, countBit-1, length, '0');
        } cArr[length-1] = '1';
        return String.valueOf(cArr);
    }
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("010"));
        System.out.println(maximumOddBinaryNumber("0101"));
    }
}

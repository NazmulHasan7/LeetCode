// 171. Excel Sheet Column Number
package Easy;

public class Easy_171_Excel_Sheet_Column_Number {
    public static int titleToNumber(String columnTitle) {
        int number = 0;
        int length = columnTitle.length();
        for (char c : columnTitle.toCharArray())
            number += ((c-'A'+1) * (int) Math.pow(26, --length));
        return number;
    }
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }
}

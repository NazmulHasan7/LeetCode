// 1903. Largest Odd Number in String
package Easy;

public class Easy_1903_Largest_Odd_Number_in_String {
    public static String largestOddNumber(String num) {
        int length = num.length();
        for (int i=length-1; i>=0; i--)
            if ((num.charAt(i)-'0') % 2 != 0)
                return num.substring(0, i+1);
        return "";
    }
    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
    }
}

// 2264. Largest 3-Same-Digit Number in String
package Easy;

public class Easy_2264_Largest_3_Same_Digit_Number_in_String {
    public static String largestGoodInteger(String num) {
        char max=' ', c;
        for (int i=0; i<num.length()-2; i++) {
            c = num.charAt(i);
            if (c == num.charAt(i+1) && c == num.charAt(i+2))
                if (c > max) max = c;
        } return (max == ' ') ? "" : String.valueOf(max).repeat(3);
    }
    public static String largestGoodIntegerBetter(String num) {
        String number;
        for (int i=9; i>=0; i--) {
            number = String.valueOf(i).repeat(3);
            if (num.contains(number)) return number;
        } return "";
    }
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
        System.out.println(largestGoodInteger("2300019"));
        System.out.println(largestGoodInteger("42352338"));
    }
}

// 405. Convert a Number to Hexadecimal
package Easy;

public class Easy_405_Convert_a_Number_to_Hexadecimal {
    public static String toHex(int num) {
        if (num == 0) return "0";

        // Handle negative number
        long n = num < 0 ? num + (long) Math.pow(2, 32) : num;
        char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int rem = (int) (n % 16);
            sb.append(hex[rem]);
            n /= 16;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
    }
}

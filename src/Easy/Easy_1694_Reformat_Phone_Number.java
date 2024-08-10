// 1694. Reformat Phone Number
package Easy;

public class Easy_1694_Reformat_Phone_Number {
    public static String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int digitCount = 0;
        // Remove spaces and dashes, and count the digits
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
                sb.append(c);
            }
        }
        // Format the digits
        int i = 0;
        while (digitCount > 0) {
            if (digitCount > 4) {
                sb.insert(i+3, '-');
                i += 4;
                digitCount -= 3;
            } else if (digitCount == 3) {
                if (i+3 != sb.length())
                    sb.insert(i+3, '-');
                break;
            } else if (digitCount == 4) {
                if (i+2 != sb.length())
                    sb.insert(i+2, '-');
                break;
            } else break;
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(reformatNumber("1-23-45 6"));
        System.out.println(reformatNumber("123 4-567"));
        System.out.println(reformatNumber("123 4-7"));
        System.out.println(reformatNumber("123 4-"));
    }
}

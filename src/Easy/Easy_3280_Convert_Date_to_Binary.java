// 3280. Convert Date to Binary
package Easy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Easy_3280_Convert_Date_to_Binary {
    private static String binary(int n) {
        List<Character> bin = new ArrayList<>();
        while (n != 0) {
            bin.add((char) ((n % 2) + '0'));
            n /= 2;
        }
        Collections.reverse(bin);
        StringBuilder binaryString = new StringBuilder();
        for (char c : bin) binaryString.append(c);
        return binaryString.toString();
    }
    public static String convertDateToBinary(String date) {
        // char[] crr = date.toCharArray();
        // int year = (crr[0]-'0') * 1000 + (crr[1]-'0') * 100 + (crr[2]-'0') * 10 + crr[3]-'0';
        // int month = (crr[5]-'0') * 10 + (crr[6]-'0');
        // int day = (crr[8]-'0') * 10 + (crr[9]-'0');
        // return binary(year) + "-" + binary(month) + "-" + binary(day);

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));

        StringBuilder answer = new StringBuilder();
        answer.append(Integer.toBinaryString(year));
        answer.append("-");
        answer.append(Integer.toBinaryString(month));
        answer.append("-");
        answer.append(Integer.toBinaryString(day));
        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(convertDateToBinary("2080-02-29"));
        System.out.println(convertDateToBinary("1900-01-01"));
    }
}

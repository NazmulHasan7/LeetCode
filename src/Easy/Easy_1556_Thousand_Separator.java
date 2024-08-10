// 1556. Thousand Separator
package Easy;

public class Easy_1556_Thousand_Separator {
    public static String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        if (n < 1000) return String.valueOf(n);

        while (n != 0) {
            if (count == 3) {
                sb.append(".");
                count = 0;
            } sb.append(n % 10);
            count++;
            n /= 10;
        } return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(thousandSeparator(987));
        System.out.println(thousandSeparator(1234));
        System.out.println(thousandSeparator(123456789));
    }
}

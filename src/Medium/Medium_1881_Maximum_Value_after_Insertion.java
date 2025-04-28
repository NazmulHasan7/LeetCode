// 1881. Maximum Value after Insertion
package Medium;

public class Medium_1881_Maximum_Value_after_Insertion {
    private static String lookForMinimum(String number, int x) {
        StringBuilder sb = new StringBuilder("-");
        int n = number.length();
        boolean inserted = false;

        for (int i=1; i<n; i++) {
            char c = number.charAt(i);
            if ((c - '0') > x) {
                sb.append(x);
                sb.append(number.substring(i));
                inserted = true;
                break;
            }
            sb.append(c);
        }
        if (!inserted) sb.append(x);
        return sb.toString();
    }
    private static String lookForMaximum(String number, int x) {
        StringBuilder sb = new StringBuilder();
        int n = number.length();
        boolean inserted = false;

        for (int i=0; i<n; i++) {
            char c = number.charAt(i);
            if ((c - '0') < x) {
                sb.append(x);
                sb.append(number.substring(i));
                inserted = true;
                break;
            }
            sb.append(c);
        }
        if (!inserted) sb.append(x);
        return sb.toString();
    }
    public static String maxValue(String n, int x) {
        // if (n.charAt(0) == '-')
        // return lookForMinimum(n, x);
        // return lookForMaximum(n, x);

        int len = n.length();
        boolean isNeg = n.charAt(0) == '-';
        int i = isNeg ? 1 : 0;
        StringBuilder sb = new StringBuilder(n);

        while (i < len) {
            int d = n.charAt(i) - '0';
            if ((isNeg && x < d) || (!isNeg && x > d))
                break;
            i++;
        }
        sb.insert(i, x);
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(maxValue("99", 9));
        System.out.println(maxValue("-13", 2));
    }
}

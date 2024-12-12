// 8. String to Integer (atoi)
package Medium;

public class Medium_8_String_to_Integer_atoi {
    public static int myAtoi(String s) {
        int len = s.length();
        int idx = 0;
        long number = 0;

        // ignore leading whitespaces
        while (idx < len && s.charAt(idx) == ' ')
            idx++;

        // check for sign
        boolean isNeg = false;
        if (idx < len) {
            char c = s.charAt(idx);
            if (c == '+' || c == '-') {
                isNeg = c == '-';
                idx++;
            }
        }

        while (idx < len && Character.isDigit(s.charAt(idx))) {
            number = number * 10 + s.charAt(idx) - '0';
            idx++;

            // check overflow
            if (isNeg) {
                if (-number < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            } else {
                if (number > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
        }
        return (int) (isNeg ? -number : number);
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi(" -042"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("words and 987"));
    }
}

// 831. Masking Personal Information
package Medium;

public class Medium_831_Masking_Personal_Information {
    public static String maskPII(String s) {
        StringBuilder sb = new StringBuilder();

        // email address masking
        if (Character.isAlphabetic(s.charAt(0))) {
            s = s.toLowerCase();
            int splitIndex = s.indexOf('@'); // name, domain
            // add name
            sb.append(s.charAt(0)).append("*****").append(s.charAt(splitIndex-1));
            sb.append(s.substring(splitIndex));
            return sb.toString();
        }
        // phone number masking
        else {
            int digitCount = 0;
            for (char c : s.toCharArray())
                if (Character.isDigit(c))
                    digitCount++;

            if (digitCount > 10)
                sb.append('+');

            while (digitCount-- > 10)
                sb.append('*');

            if (!sb.isEmpty()) sb.append('-');
            sb.append("***").append('-').append("***-");

            // handle last 4 digits
            StringBuilder last4Digits = new StringBuilder();
            int count = 0;
            for (int i=s.length()-1; i>=0 && count<4; i--) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    last4Digits.append(c);
                    count++;
                }
            } sb.append(last4Digits.reverse());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(maskPII("LeetCode@LeetCode.com"));
        System.out.println(maskPII("AB@qq.com"));
        System.out.println(maskPII("1(234)567-890"));
    }
}

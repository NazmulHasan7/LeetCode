// 468. Validate IP Address
package Medium;

public class Medium_468_Validate_IP_Address {

    public static String validIPAddress(String queryIP) {
        if (queryIP.contains(".") && !queryIP.startsWith(".") && !queryIP.endsWith(".")) {
            String[] x = queryIP.split("\\.");
            if (x.length == 4)
                return isIPv4(x) ? "IPv4" : "Neither";
        } else if (queryIP.contains(":") && !queryIP.startsWith(":") && !queryIP.endsWith(":")) {
            String[] x = queryIP.split(":");
            if (x.length == 8)
                return isIPv6(x) ? "IPv6" : "Neither";
        }
        return "Neither";
    }
    private static boolean isIPv4(String[] x) {
        for (String xi : x) {
            // can be 0 to 255
            if (xi.isEmpty() || xi.length() > 3) return false;
            // cannot start with 0 but can contain only 0
            if (xi.length() > 1 && xi.charAt(0) == '0') return false;

            for (char c : xi.toCharArray()) // contains digit only
                if (!Character.isDigit(c)) return false;
            // check if the number is below 256
            if (Integer.parseInt(xi) > 255) return false;
        }
        return true;
    }
    private static boolean isIPv6(String[] x) {
        for (String xi : x) {
            // length of xi is between 1 and 4
            if (xi.isEmpty() || xi.length() > 4) return false;
            // can start with 0
            // contains 0-9, a-f, A-F
            for (char c : xi.toCharArray()) {
                if (!(c >= '0' && c <= '9') &&
                        !(c >= 'a' && c <= 'f') &&
                        !(c >= 'A' && c <= 'F'))
                    return false;
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("256.256.256.256"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}

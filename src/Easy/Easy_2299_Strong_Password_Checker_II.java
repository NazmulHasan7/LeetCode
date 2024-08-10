// 2299. Strong Password Checker II
package Easy;

public class Easy_2299_Strong_Password_Checker_II {
    public static boolean strongPasswordCheckerIIBetter(String password) {
        if (password.length() >= 8) {
            boolean lower = false, upper = false, digit = false, special = false;
            String specialStr = "!@#$%^&*()-+";

            for (int i = 0; i < password.length() - 1; i++)
                if (password.charAt(i) == password.charAt(i + 1))
                    return false;

            for (char ch : password.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') lower = true;
                else if (ch >= 'A' && ch <= 'Z') upper = true;
                else if (ch >= '0' && ch <= '9') digit = true;
                else if (specialStr.indexOf(ch) >= 0) special = true;
            } return (lower && upper && digit && special);
        } return false;
    }
    public static boolean strongPasswordCheckerII(String password) {
        if (password.length() >= 8) {
            boolean lower = false, upper = false, digit = false, special = false;
            String specialStr = "!@#$%^&*()-+";
            char prev = '\0';

            for (char c : password.toCharArray()) {
                if (c == prev) return false;
                else if (Character.isUpperCase(c)) upper = true;
                else if (Character.isLowerCase(c)) lower = true;
                else if (Character.isDigit(c)) digit = true;
                else if (specialStr.indexOf(c) >= 0) special = true;
                prev = c;
            }
            return (lower && upper && digit && special);
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(strongPasswordCheckerII("IloveLe3tcode!"));
        System.out.println(strongPasswordCheckerII("Me+You--IsMyDream"));
        System.out.println(strongPasswordCheckerII("1aB!"));
    }
}

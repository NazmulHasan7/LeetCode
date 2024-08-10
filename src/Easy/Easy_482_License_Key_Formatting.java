// 482. License Key Formatting
package Easy;

public class Easy_482_License_Key_Formatting {
    public static String licenseKeyFormatting(String s, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) != '-') {
                if (count == k) {
                    sb.append('-');
                    count = 0;
                } sb.append(Character.toUpperCase(s.charAt(i)));
                count++;
            }
        } return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
    }
}

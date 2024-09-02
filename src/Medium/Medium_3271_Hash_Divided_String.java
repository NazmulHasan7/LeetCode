// 3271. Hash Divided String
package Medium;

public class Medium_3271_Hash_Divided_String {
    public static String stringHash(String s, int k) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i+=k) {
            long hashValues = 0;
            for (int j=0; j<k; j++)
                hashValues += s.charAt(i+j) - 97;

            hashValues %= 26;
            sb.append((char)(hashValues + 97));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(stringHash("abcd", 2));
        System.out.println(stringHash("mxz", 3));
    }
}

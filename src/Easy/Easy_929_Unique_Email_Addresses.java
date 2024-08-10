// 929. Unique Email Addresses
package Easy;
import java.util.HashSet;

public class Easy_929_Unique_Email_Addresses {
    public static String processString(String email) {
        StringBuilder sb = new StringBuilder();
        String[] parts = email.split("@");
        for (char c : parts[0].toCharArray()) {
            if (c == '+') break;
            else if (c != '.') sb.append(c);
        }  sb.append('@').append(parts[1]);
        return sb.toString();
    }
    public static String processStringBetter(String email) {
        char[] cArr = email.toCharArray();
        int read=0, write=0, length = cArr.length;
        while (cArr[read] != '@') {
            if (cArr[read] == '+') {
                while (cArr[read] != '@')
                    read++;
                break;
            } else if (cArr[read] != '.')
                cArr[write++] = cArr[read];
            read++;
        }
        while (read < length)
            cArr[write++] = cArr[read++];
        return String.valueOf(cArr, 0, write);
    }
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            // email = processString(email);
            set.add(processStringBetter(email));
        } return set.size();
    }
    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[] {
                "test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"
        }));
        System.out.println(numUniqueEmails(new String[] {"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
    }
}

// 93. Restore IP Addresses
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_93_Restore_IP_Addresses {
    static List<String> answer = new ArrayList<>();
    static int n;
    private static boolean isValidSegment(String s) {
        if (s.isEmpty()) return false;
        // A valid string should be of length 0 to 3
        if (s.length() > 3) return false;
        // Cannot start with 0 when length > 1
        if (s.length() > 1 && s.charAt(0) == '0') return false;

        int numValue = Integer.parseInt(s);
        return numValue >= 0 && numValue <= 255;
    }
    private static void backtrack(StringBuilder curr, String s, int idx, int segments) {
        if (segments == 4 && idx == n) {
            answer.add(curr.toString());
            return;
        }
        if (segments == 4 || idx == n) return;

        for (int i=1; i<=3; i++) {
            if (idx + i > n) break;
            String segment = s.substring(idx, idx+i);
            if (isValidSegment(segment)) {
                int beforeLength = curr.length();
                if (segments > 0) curr.append('.');

                // Pick current segment and explore
                curr.append(segment);
                backtrack(curr, s, idx+i, segments+1);
                // Undo the pick
                curr.setLength(beforeLength);
            }
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        answer = new ArrayList<>();
        n = s.length();
        if (n < 4 || n > 12) return answer;
        backtrack(new StringBuilder(), s,0,0);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("101023"));
    }
}

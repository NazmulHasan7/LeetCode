// 3295. Report Spam Message
package Medium;
import java.util.HashSet;

public class Medium_3295_Report_Spam_Message {
    public static boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> banned = new HashSet<>();
        for (String word : bannedWords)
            banned.add(word);

        int count = 0;
        for (String msg : message) {
            if (banned.contains(msg)) {
                count++;
                if (count == 2) return true;
            }
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(reportSpam(new String[]{"hello","world","leetcode"}, new String[]{"world","hello"}));
        System.out.println(reportSpam(new String[]{"hello","programming","fun"}, new String[]{"world","programming","leetcode"}));
    }
}

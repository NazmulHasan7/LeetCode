// 131. Palindrome Partitioning
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_131_Palindrome_Partitioning {
    static List<List<String>> answer;
    public static List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        backtrack(s.toCharArray(), 0, new ArrayList<>());
        return answer;
    }
    private static boolean isPalindrome(char[] crr, int start, int end) {
        while (start <= end)
            if (crr[start++] != crr[end--])
                return false;
        return true;
    }
    private static void backtrack(char[] crr, int start, List<String> temp) {
        if (start == crr.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        // Explore all possible partitions
        for (int end = start; end < crr.length; end++) {
            // If the current substring is a palindrome, add it to the current list
            if (isPalindrome(crr, start, end)) {
                temp.add(new String(crr, start, end-start+1));
                // Recur to find other partitions
                backtrack(crr, end+1, temp);
                // Backtrack to explore other partitions
                temp.removeLast();
            }
        }
    }
    public static void main(String[] args) {
        List<List<String>> answer = partition("aab");
        System.out.println(answer);
        answer = partition("a");
        System.out.println(answer);
    }
}

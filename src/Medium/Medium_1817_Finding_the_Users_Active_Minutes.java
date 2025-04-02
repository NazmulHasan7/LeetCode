// 1817. Finding the Users Active Minutes
package Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Medium_1817_Finding_the_Users_Active_Minutes {
    /* Given Information: You have logs of users' actions on LeetCode.
    Each log entry consists of two elements: the user ID (IDi) and the time when the action was performed (time i).
    This information is stored in a 2D integer array logs.

    User Active Minutes (UAM): For a given user, their User Active Minutes (UAM) is defined as the number of
    unique minutes during which they performed an action on LeetCode. For example, if a user performed actions at
    minutes 1, 2, and 3, their UAM would be 3, as they were active for three unique minutes.

    Task: You need to calculate an array called answer of size k. For each index j (where 1 <= j <= k) in the answer
    array, answer[j] represents the number of users whose UAM equals j */

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] log : logs)
            map.computeIfAbsent(log[0], s -> new HashSet<>()).add(log[1]);

        int[] answer = new int[k];
        for (int key : map.keySet()) {
            int count = map.get(key).size();
            answer[count-1]++;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findingUsersActiveMinutes(
                new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}}, 5)));
        System.out.println(Arrays.toString(findingUsersActiveMinutes(
                new int[][]{{1,1},{2,2},{2,3}}, 4)));
    }
}

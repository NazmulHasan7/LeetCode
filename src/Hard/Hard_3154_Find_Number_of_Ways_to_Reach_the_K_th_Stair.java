// 3154. Find Number of Ways to Reach the K-th Stair
package Hard;
import java.util.HashMap;

public class Hard_3154_Find_Number_of_Ways_to_Reach_the_K_th_Stair {
    public static int waysToReachStair(int k) {
        return solve(1, k, 0, 1, new HashMap<String, Integer>());
    }
    private static int solve(int position, int destination, int jump, int goDown, HashMap<String, Integer> dp) {
        // Note that it is possible that Alice reaches the stair k,
        // and performs some operations to reach the stair k again.
        if (position > destination+1)
            return 0; // As we cannot go back to kth stair, as the maximum we can go down is 1

        String key = position + "_" + jump + "_" + goDown;
        if (dp.containsKey(key))
            return dp.get(key);

        int ways = 0;
        if (position == destination)
            ways++; // one possible way found

        if (position != 0 && goDown == 1) {
            // cannot go down consecutively or from stair 0
            ways += solve(position-1, destination, jump, 0, dp);
        }
        ways += solve(position + (int) Math.pow(2, jump), destination, jump+1, 1, dp);

        dp.put(key, ways);
        return ways;
    }
    public static void main(String[] args) {
        System.out.println(waysToReachStair(0));
        System.out.println(waysToReachStair(1));
    }
}

// 2225. Find Players With Zero or One Losses
package Medium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Medium_2225_Find_Players_With_Zero_or_One_Losses {
    // TC -> 2*O(n) + O(maxId), SC -> O(maxId) [Count array] + O(maxId) [Set]
    public static List<List<Integer>> findWinners(int[][] matches) {
        int maxId = Integer.MIN_VALUE;
        HashSet<Integer> playedGame = new HashSet<>();

        for (int[] playerIds : matches) {
            maxId = Math.max(maxId, Math.max(playerIds[0], playerIds[1]));
            playedGame.add(playerIds[0]);
            playedGame.add(playerIds[1]);
        }

        int[] count = new int[maxId+1];

        for (int[] playerIds : matches)
            count[playerIds[1]]++; // {winner, looser}

        List<Integer> neverLost = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();

        for (int i=1; i<=maxId; i++) {
            if (!playedGame.contains(i))
                continue;
            if (count[i] == 0) neverLost.add(i);
            else if (count[i] == 1) oneLose.add(i);
        }
        return List.of(neverLost, oneLose);
    }

    public List<List<Integer>> findWinnersOpt(int[][] matches) {
        int[] losses = new int[100001];

        for (int i=0; i<matches.length; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];

            if (losses[win] == 0)
                losses[win] = -1;

            if (losses[loss] == -1) losses[loss] = 1;
            else losses[loss]++;
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<losses.length; i++) {
            if (losses[i] == -1)
                zeroLoss.add(i);
            else if (losses[i] == 1)
                oneLoss.add(i);
        }

        result.add(zeroLoss);
        result.add(oneLoss);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
        System.out.println(findWinners(new int[][]{{2,3},{1,3},{5,4},{6,4}}));
    }
}

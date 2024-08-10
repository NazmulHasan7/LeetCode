// 2410. Maximum Matching of Players With Trainers
package Medium;
import java.util.Arrays;

public class Medium_2410_Maximum_Matching_of_Players_With_Trainers {
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int count = 0;
        for (int i=0, j=0; i<players.length && j<trainers.length; ) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
            } j++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(matchPlayersAndTrainers(new int[]{4,7,9}, new int[]{8,2,5,8}));
        System.out.println(matchPlayersAndTrainers(new int[]{1,1,1}, new int[]{10}));
    }
}

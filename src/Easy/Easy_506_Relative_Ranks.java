// 506. Relative Ranks
package Easy;
import java.util.Arrays;

public class Easy_506_Relative_Ranks {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] scorePairs = new int[n][2];

        for (int i=0; i<n; i++)
            scorePairs[i] = new int[]{i, score[i]};

        Arrays.sort(scorePairs, (o1, o2) -> o2[1] - o1[1]);
        String[] answer = new String[n];

        for (int i=0; i<n; i++) {
            if (i == 0)
                answer[scorePairs[i][0]] = "Gold Medal";
            else if (i == 1)
                answer[scorePairs[i][0]] = "Silver Medal";
            else if (i == 2)
                answer[scorePairs[i][0]] = "Bronze Medal";
            else
                answer[scorePairs[i][0]] = String.valueOf(i+1);
        } return answer;
    }
    public static String[] findRelativeRanksBetter(int[] score) {
        int n = score.length;
        int maxScore = 0;
        for (int sc : score)
            maxScore = Math.max(maxScore, sc);

        int[] score2Index = new int[maxScore+1];
        for (int i=0 ; i<n ; i++)
            score2Index[score[i]] = i+1;

        String[] answer = new String[n];
        int place = 1;

        for (int i=maxScore; i>=0 ; i--) {
            if (score2Index[i] == 0)
                continue;
            int actualIndex = score2Index[i] - 1;
            if (place == 1)
                answer[actualIndex] = "Gold Medal";
            else if (place == 2)
                answer[actualIndex] = "Silver Medal";
            else if (place == 3)
                answer[actualIndex] = "Bronze Medal";
            else
                answer[actualIndex] = String.valueOf(place);
            place++;
        } return answer;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[] {5,4,3,2,1};
        System.out.println(Arrays.toString(findRelativeRanks(arr1)));
        int[] arr2 = new int[] {10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(arr2)));
    }
}

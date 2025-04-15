// 1366. Rank Teams by Votes
package Medium;
import java.util.Arrays;
import java.util.Comparator;

public class Medium_1366_Rank_Teams_by_Votes {
    public static String rankTeams(String[] votes) {
        int n = votes[0].length(); // no of teams

        // store the frequencies // last index stores the team itself
        int[][] voteCount = new int[26][n+1];
        for (int i=0; i<26; i++)
            voteCount[i][n] = i;

        for (String vote : votes)
            for (int i=0; i<n; i++) // i indicates position
                voteCount[vote.charAt(i)-'A'][i]++;

        Arrays.sort(voteCount, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                for (int i=0; i<n; i++) {
                    if (t2[i] > t1[i])
                        return 1; // descending order
                    if (t2[i] < t1[i])
                        return -1; // no swap, elements are in correct order
                }
                return t1[n] - t2[n]; // in case tie cannot be broken, sort by char [asc]
            }
        });
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<n; i++)
            answer.append((char)('A' + voteCount[i][n]));

        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"}));
        System.out.println(rankTeams(new String[]{"WXYZ","XYZW"}));
        System.out.println(rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
    }
}

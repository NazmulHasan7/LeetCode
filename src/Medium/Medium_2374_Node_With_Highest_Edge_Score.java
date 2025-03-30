// 2374. Node With Highest Edge Score
package Medium;

public class Medium_2374_Node_With_Highest_Edge_Score {
    public static int edgeScore(int[] edges) {
        int n = edges.length;
        long[] scores = new long[n];

        long maxScore = 0;
        int answer = -1;

        for (int i=0; i<n; i++) {
            scores[edges[i]] += i;
            if (scores[edges[i]] > maxScore) {
                maxScore = scores[edges[i]];
                answer = edges[i];
            } else if (scores[edges[i]] == maxScore) {
                answer = Math.min(answer, edges[i]);
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(edgeScore(new int[]{1,0,0,0,0,7,7,5}));
        System.out.println(edgeScore(new int[]{2,0,0,2}));
    }
}

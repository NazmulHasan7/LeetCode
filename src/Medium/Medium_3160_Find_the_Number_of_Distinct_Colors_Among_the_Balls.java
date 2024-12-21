// 3160. Find the Number of Distinct Colors Among the Balls
package Medium;
import java.util.Arrays;
import java.util.HashMap;

public class Medium_3160_Find_the_Number_of_Distinct_Colors_Among_the_Balls {
    public static int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int idx = 0;

        HashMap<Integer, Integer> ballColorMap = new HashMap<>();
        HashMap<Integer, Integer> colorBallCount = new HashMap<>();

        for (int[] query : queries) {
            int ball = query[0];
            int color = query[1];

            if (ballColorMap.containsKey(ball)) {
                int currColor = ballColorMap.get(ball);
                if (currColor != color) {
                    colorBallCount.put(currColor, colorBallCount.get(currColor)-1);
                    if (colorBallCount.get(currColor) == 0)
                        colorBallCount.remove(currColor);

                    ballColorMap.put(ball, color);
                    colorBallCount.put(color, colorBallCount.getOrDefault(color, 0) + 1);
                } // Else -> trying to color the ball with the same color as it is now -> skip
            } else {
                ballColorMap.put(ball, color);
                colorBallCount.put(color, colorBallCount.getOrDefault(color, 0) + 1);
            }

            answer[idx++] = colorBallCount.size();
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(queryResults(4, new int[][]{{1,4},{2,5},{1,3},{3,4}})));
        System.out.println(Arrays.toString(queryResults(4, new int[][]{{0,1},{1,2},{2,2},{3,4},{4,5}})));
    }
}

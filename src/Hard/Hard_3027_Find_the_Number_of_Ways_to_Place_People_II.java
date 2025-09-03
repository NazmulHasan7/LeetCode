// 3027. Find the Number of Ways to Place People II
package Hard;
import java.util.Arrays;

public class Hard_3027_Find_the_Number_of_Ways_to_Place_People_II {
    public static int numberOfPairs(int[][] points) {
        int n = points.length;
        int answer = 0;
        // Sort -> x increasing, y decreasing
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        for (int i=0; i<n; i++) {
            // since the array is sorted in x increasing, top x <= next x
            int topY = points[i][1];
            int maxY = Integer.MIN_VALUE;

            for (int j=i+1; j<n; j++) {
                int bottomY = points[j][1];

                if (bottomY <= topY && bottomY > maxY) {
                    answer++;
                    maxY = bottomY;
                    if (bottomY == topY) break;
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[][]{{1,1},{2,2},{3,3}}));
        System.out.println(numberOfPairs(new int[][]{{6,2},{4,4},{2,6}}));
        System.out.println(numberOfPairs(new int[][]{{3,1},{1,3},{1,1}}));
    }
}

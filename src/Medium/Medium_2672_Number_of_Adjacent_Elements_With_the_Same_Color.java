// 2672. Number of Adjacent Elements With the Same Color
package Medium;
import java.util.Arrays;

public class Medium_2672_Number_of_Adjacent_Elements_With_the_Same_Color {
    public static int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] answer = new int[queries.length];
        int sameColor = 0;

        for (int i=0; i<queries.length; i++) {
            int idx = queries[i][0];
            int c = queries[i][1];

            // check the left neighbor before updating the colors
            /* if (idx > 0 && colors[idx-1] != 0 && colors[idx-1] == colors[idx])
                sameColor--;
            // same as check the right neighbor
            if (idx < n-1 && colors[idx+1] != 0 && colors[idx+1] == colors[idx])
                sameColor--;

            colors[idx] = c;
            // now again check the neighbors
            if (idx > 0 && colors[idx-1] == colors[idx])
                sameColor++;
            if (idx < n-1 && colors[idx+1] == colors[idx])
                sameColor++; */

            int prev = (idx > 0) ? colors[idx-1] : 0;
            int next = (idx < n-1) ? colors[idx+1] : 0;

            // check before coloring
            if (colors[idx] != 0 && colors[idx] == prev) sameColor--;
            if (colors[idx] != 0 && colors[idx] == next) sameColor--;

            colors[idx] = c;
            // check after coloring
            if (c == prev) sameColor++;
            if (c == next) sameColor++;
            answer[i] = sameColor;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(colorTheArray(4, new int[][]{{0,2},{1,2},{3,1},{1,1},{2,1}})));
        System.out.println(Arrays.toString(colorTheArray(1, new int[][]{{0,100000}})));
    }
}

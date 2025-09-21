// 406. Queue Reconstruction by Height
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_406_Queue_Reconstruction_by_Height {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            // For same height -> smaller k first
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        List<int[]> answer = new ArrayList<>();
        for (int[] p : people)
            answer.add(p[1], p);

        return answer.toArray(new int[people.length][2]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}})));
        System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}})));
    }
}

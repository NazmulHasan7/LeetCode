// 986. Interval List Intersections
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_986_Interval_List_Intersections {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length, len2 = secondList.length;
        if (len1 == 0 || len2 == 0)
            return new int[][]{{}};

        int ptr1 = 0, ptr2 = 0;
        int start1, end1, start2, end2;
        List<int[]> answer = new ArrayList<>();

        while (ptr1 < len1 && ptr2 < len2) {
            start1 = firstList[ptr1][0];
            end1   = firstList[ptr1][1];
            start2 = secondList[ptr2][0];
            end2   = secondList[ptr2][1];

            if (start1 > end2) ptr2++;
            else if (start2 > end1) ptr1++;
                // Intersects found
            else {
                answer.add(new int[] {Math.max(start1, start2), Math.min(end1, end2)});
                if (end1 < end2) ptr1++;
                else ptr2++;
            }
        } return answer.toArray(new int[answer.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = intervalIntersection(
                new int[][] {{0,2},{5,10},{13,23},{24,25}},
                new int[][] {{1,5},{8,12},{15,24},{25,26}}
        );
        for (int[] array : arr)
            System.out.println(Arrays.toString(array));
    }
}

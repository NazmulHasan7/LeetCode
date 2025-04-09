// 274. H-Index
package Medium;
import java.util.Arrays;

public class Medium_274_H_Index {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int start = 0, end = n-1;

        while (start <= end) {
            int mid = start + (end-start) / 2;
            if (citations[mid] >= n-mid)
                end = mid - 1; // search for lower h index value
            else start = mid + 1;
        }
        return n - start;
    }
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3,0,6,1,5}));
        System.out.println(hIndex(new int[]{1,3,1}));
    }
}

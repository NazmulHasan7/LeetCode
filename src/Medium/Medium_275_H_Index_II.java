// 275. H-Index II
package Medium;

public class Medium_275_H_Index_II {
    public static int hIndex(int[] citations) {
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
        System.out.println(hIndex(new int[]{0,1,3,5,6}));
        System.out.println(hIndex(new int[]{1,2,100}));
    }
}

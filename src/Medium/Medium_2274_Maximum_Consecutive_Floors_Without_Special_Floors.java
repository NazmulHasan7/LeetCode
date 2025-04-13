// 2274. Maximum Consecutive Floors Without Special Floors
package Medium;
import java.util.Arrays;

public class Medium_2274_Maximum_Consecutive_Floors_Without_Special_Floors {
    private static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quicksort(arr, start, pIndex-1);
            quicksort(arr, pIndex+1, end);
        }
    }
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i=start; i<end; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int maxConsecutive(int bottom, int top, int[] special) {
        int n = special.length;
        quicksort(special, 0, n-1);

        int answer = 0;
        for (int sp : special) {
            answer = Math.max(answer, sp-bottom);
            bottom = sp + 1;
        }
        return Math.max(answer, top - special[n-1]);
    }
    public static int maxConsecutiveBetter(int bottom, int top, int[] special) {
        int n = special.length;
        Arrays.sort(special);
        int max = Math.max(special[0]-bottom, top-special[n-1]);

        for (int i=0; i<n-1; i++)
            max = Math.max(max, special[i+1]-special[i]-1);
        return max;
    }
    public static void main(String[] args) {
        System.out.println(maxConsecutive(2,9, new int[]{4,6}));
        System.out.println(maxConsecutive(6,8, new int[]{7,6,8}));
    }
}

// 1539. Kth Missing Positive Number
package Easy;

public class Easy_1539_Kth_Missing_Positive_Number {
    public static int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int arrPtr = 0;
        int number = 1;
        while (missingCount != k) {
            if (arrPtr < arr.length && number == arr[arrPtr])
                arrPtr++;
            else missingCount++;
            number++;
        } return number-1;
    }
    public static int findKthPositiveBetter(int[] arr, int k) {
        int low = 0, high = arr.length-1;
        int missing = 0, mid = 0;
        while (low <= high) {
            mid = (high + low) / 2;
            // arr[i] -> actual value at index i
            // i -> expected value at index i+1 (0 based)
            missing = arr[mid] - (mid+1);
            if (missing < k) low = mid + 1;
            else high = mid - 1;
        }
        // When loop exits -> low > high
        // arr[high] + missing
        // arr[high] + k - (arr[high] - high - 1)
        // => high + 1 + k
        return high + 1 + k;
    }
    public static void main(String[] args) {
        System.out.println(findKthPositiveBetter(new int[]{2,3,4,7,11}, 5));
        System.out.println(findKthPositiveBetter(new int[]{1,2,3,4}, 2));
    }
}

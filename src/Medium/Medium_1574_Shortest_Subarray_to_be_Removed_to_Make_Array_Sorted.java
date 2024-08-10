// 1574. Shortest Sub-array to be Removed to Make Array Sorted
package Medium;

public class Medium_1574_Shortest_Subarray_to_be_Removed_to_Make_Array_Sorted {
    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Longest non-decreasing prefix
        int left = 0; // Left sorted array
        while (left < n-1 && arr[left] <= arr[left+1])
            left++;
        if (left == n-1) return 0; // Array is already sorted

        // Longest non-decreasing suffix
        int right = n - 1; // Right sorted array
        while (right > 0 && arr[right] >= arr[right-1])
            right--;

        // Minimum sub-array length to remove by combining prefix and suffix
        int removeLength = Math.min(n-left-1, right); // Remove one part entirely

        // Optimization : Try to remove the middle part
        // Combining the prefix and suffix array
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                removeLength = Math.min(removeLength, j-i-1);
                i++;
            } else {
                j++;
            }
        } return removeLength;
    }
    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
        System.out.println(findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3}));
    }
}

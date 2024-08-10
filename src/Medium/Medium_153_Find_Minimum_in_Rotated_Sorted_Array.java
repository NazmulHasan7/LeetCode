// 153. Find Minimum in Rotated Sorted Array
package Medium;

public class Medium_153_Find_Minimum_in_Rotated_Sorted_Array {
    // Left sorted portion values are always greater than the values in right sorted portion
    public static int findMin(int[] arr) {
        int low = 0, high = arr.length-1;
        while (low < high) {
            int mid = (low + high) / 2;
            // In Left Sorted Array, minimum should be on the right
            if (arr[mid] > arr[high])
                low = mid + 1;
                // Minimum could be at mid or on the left
            else high = mid;
        } return arr[low];
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
}

// 852. Peak Index in a Mountain Array
package Medium;

public class Medium_852_Peak_Index_in_a_Mountain_Array {
    public static int peakIndexInMountainArray(int[] arr) {
        // The array is guaranteed to be a mountain array
        int start = 1, end = arr.length-2;
        while (start <= end) {
            int mid = (start+end) / 2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                return mid;
                // Still in increasing order
            else if (arr[mid] < arr[mid+1])
                start = mid + 1;
            else end = mid - 1;
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(peakIndexInMountainArray(new int[]{0,2,1,0}));
        System.out.println(peakIndexInMountainArray(new int[]{0,10,5,2}));
    }
}

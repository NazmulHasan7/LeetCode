// 2740. Find the Value of the Partition
package Medium;

public class Medium_2740_Find_the_Value_of_the_Partition {
    private static void quicksort(int[] nums, int start, int end) {
        if (start < end) {
            int pIndex = parition(nums, start, end);
            quicksort(nums, start, pIndex-1);
            quicksort(nums, pIndex+1, end);
        }
    }
    private static int parition(int[] arr, int start, int end) {
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
    public static int findValueOfPartition(int[] nums) {
        int n = nums.length;
        int answer = Integer.MAX_VALUE;
        quicksort(nums, 0, n-1);

        for (int i=1; i<n; i++)
            answer = Math.min(answer, nums[i] - nums[i-1]);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(findValueOfPartition(new int[]{1,3,2,4}));
        System.out.println(findValueOfPartition(new int[]{100,1,10}));
    }
}

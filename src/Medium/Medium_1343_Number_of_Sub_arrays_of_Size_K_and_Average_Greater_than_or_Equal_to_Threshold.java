// 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
package Medium;

public class Medium_1343_Number_of_Sub_arrays_of_Size_K_and_Average_Greater_than_or_Equal_to_Threshold {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, count = 0;
        for (int i=0; i<k; i++)
            sum += arr[i];

        threshold *= k;
        if (sum >= threshold) count++;

        int left = 1, right = k;
        while (right < arr.length) {
            sum = sum - arr[left-1] + arr[right];
            if (sum >= threshold) count++;
            left++;
            right++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4));
        System.out.println(numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3},3,6));
    }
}

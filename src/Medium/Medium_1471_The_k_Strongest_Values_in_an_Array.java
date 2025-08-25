// 1471. The k Strongest Values in an Array
package Medium;
import java.util.Arrays;

public class Medium_1471_The_k_Strongest_Values_in_an_Array {
    public static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n-1)/2];
        int[] answer = new int[k];

        int j = n-1;
        int i = 0;

        while (k > 0) {
            if (m - arr[i] > arr[j] - m)
                answer[--k] = arr[i++];
            else answer[--k] = arr[j--];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getStrongest(new int[]{1,2,3,4,5},2)));
        System.out.println(Arrays.toString(getStrongest(new int[]{1,1,3,5,5},2)));
        System.out.println(Arrays.toString(getStrongest(new int[]{6,7,11,7,6,8},5)));
    }
}

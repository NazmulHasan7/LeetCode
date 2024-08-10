// 2161. Partition Array According to Given Pivot
package Medium;
import java.util.Arrays;

public class Medium_2161_Partition_Array_According_to_Given_Pivot {
    public static int[] pivotArray(int[] nums, int pivot) {
        int size = nums.length;
        int[] answer = new int[size];
        int count = 0;

        int index = 0;
        for (int num : nums) {
            if (num < pivot)
                answer[index++] = num;
            else if (num == pivot)
                count++;
        }
        for (int i=0; i<count; i++)
            answer[index++] = pivot;

        for (int num : nums) {
            if (num > pivot)
                answer[index++] = num;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9,12,5,10,14,3,10}, 10)));
        System.out.println(Arrays.toString(pivotArray(new int[]{-3,4,3,2}, 10)));
    }
}

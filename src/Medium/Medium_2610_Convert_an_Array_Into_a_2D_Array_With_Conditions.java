// 2610. Convert an Array Into a 2D Array With Conditions
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_2610_Convert_an_Array_Into_a_2D_Array_With_Conditions {
    public static List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[201];
        int max = 0;
        for (int num : nums) {
            freq[num]++;
            max = Math.max(max, freq[num]);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (max-- > 0) result.add(new ArrayList<Integer>());

        for (int num : nums) {
            while (freq[num] > 0) {
                result.get(freq[num]-1).add(num);
                freq[num]--;
            }
        } return result;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = findMatrix(new int[] {1,3,4,1,2,3,1});
        for (List<Integer> arr : result)
            System.out.println(Arrays.toString(arr.toArray()));
    }
}

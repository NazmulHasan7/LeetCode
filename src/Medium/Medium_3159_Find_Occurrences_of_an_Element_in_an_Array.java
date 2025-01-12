// 3159. Find Occurrences of an Element in an Array
package Medium;
import java.util.ArrayList;
import java.util.Arrays;

public class Medium_3159_Find_Occurrences_of_an_Element_in_an_Array {
    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<nums.length; i++)
            if (nums[i] == x) arr.add(i);

        int n = arr.size();
        int size = queries.length;
        int[] answer = new int[size];
        for (int i=0; i<size; i++) {
            if (queries[i] > n)
                answer[i] = -1;
            else answer[i] = arr.get(queries[i]-1);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(occurrencesOfElement(new int[]{1,3,1,7}, new int[]{1,3,2,4},1)));
        System.out.println(Arrays.toString(occurrencesOfElement(new int[]{1,2,3}, new int[]{10},5)));
    }
}

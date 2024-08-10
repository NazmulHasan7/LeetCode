// 2824. Count Pairs Whose Sum is Less than Target
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_2824_Count_Pairs_Whose_Sum_is_Less_than_Target {
    public static int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i=0; i<nums.size(); i++)
            for (int j=i+1; j<nums.size(); j++)
                if (nums.get(i) + nums.get(j) < target) count++;
        return count;
    }
    public static int countPairsBetter(List<Integer> nums, int target) {
        int count = 0;
        Integer[] array = new Integer[nums.size()];
        array = nums.toArray(array);
        for (int i=0; i<array.length; i++)
            for (int j=i+1; j<array.length; j++)
                if (array[i] + array[j] < target) count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPairs(new ArrayList<>(Arrays.asList(-1,1,2,3,1)), 2));
        System.out.println(countPairs(new ArrayList<>(Arrays.asList(-6,2,5,-2,-7,-1,3)), -2));
        System.out.println(countPairsBetter(new ArrayList<>(Arrays.asList(-1,1,2,3,1)), 2));
        System.out.println(countPairsBetter(new ArrayList<>(Arrays.asList(-6,2,5,-2,-7,-1,3)), -2));
    }
}

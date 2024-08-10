// 2367. Number of Arithmetic Triplets
package Easy;
import java.util.HashSet;

public class Easy_2367_Number_of_Arithmetic_Triplets {
    public static int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[j] - nums[i] == diff) {
                    for (int k=j+1; k<n; k++)
                        if (nums[k] - nums[j] == diff) count++;
                }
            }
        }
        return count;
    }
    public static int arithmeticTripletsBetter(int[] nums, int diff) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);

        for (int num: nums)
            if (set.contains(num + diff) && set.contains(num + diff + diff))
                count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(arithmeticTriplets(new int[] {0,1,4,6,7,10}, 3));
        System.out.println(arithmeticTriplets(new int[] {4,5,6,7,8,9}, 2));
        System.out.println(arithmeticTripletsBetter(new int[] {0,1,4,6,7,10}, 3));
        System.out.println(arithmeticTripletsBetter(new int[] {4,5,6,7,8,9}, 2));
    }
}

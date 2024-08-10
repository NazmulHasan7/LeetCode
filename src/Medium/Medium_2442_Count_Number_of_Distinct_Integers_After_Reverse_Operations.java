// 2442. Count Number of Distinct Integers After Reverse Operations
package Medium;
import java.util.HashSet;

public class Medium_2442_Count_Number_of_Distinct_Integers_After_Reverse_Operations {
    public static int reverse(int num) {
        int rev = 0, rem;
        while (num != 0) {
            rev = (rev * 10) + (num % 10);
            num = num / 10;
        } return rev;
    }
    public static int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (num > 9) set.add(reverse(num));
        } return set.size();
    }
    public static int countDistinctIntegersBetter(int[] nums) {
        boolean[] seen = new boolean[1000001];
        int count = 0;
        for (int num : nums) {
            if (!seen[num]) {
                seen[num] = true;
                count++;
            }
            int rev = reverse(num);
            if (!seen[rev]) {
                seen[rev] = true;
                count++;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countDistinctIntegers(new int[] {1,13,10,12,31}));
        System.out.println(countDistinctIntegers(new int[] {2,2,2}));
        System.out.println(countDistinctIntegersBetter(new int[] {2,2,2}));
    }
}

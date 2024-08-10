// 349. Intersection of Two Arrays
package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class Easy_349_Intersection_of_Two_Arrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean[] exists = new boolean[1001];
        for (int num : nums1)
            exists[num] = true;

        ArrayList<Integer> inter = new ArrayList<>();
        for (int num : nums2) {
            if (exists[num]) {
                exists[num] = false;
                inter.add(num);
            }
        }
        int[] result = new int[inter.size()];
        for (int i=0; i<result.length; i++)
            result[i] = inter.get(i);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[] {1,2,2,1}, new int[] {2,2})));
        System.out.println(Arrays.toString(intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
    }
}

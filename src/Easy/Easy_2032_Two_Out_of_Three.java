// 2032. Two Out of Three
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_2032_Two_Out_of_Three {
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result = new ArrayList<>();
        int[] frequency1 = new int[101];
        int[] frequency2 = new int[101];
        int[] frequency3 = new int[101];

        for (int num : nums1) frequency1[num] = 1;
        for (int num : nums2) frequency2[num] = 1;
        for (int num : nums3) frequency3[num] = 1;

        for (int i=0; i<frequency1.length; i++)
            if (frequency1[i] + frequency2[i] + frequency3[i] >= 2) result.add(i);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(twoOutOfThree(new int[] {1,1,3,2}, new int[] {2,3}, new int[] {3}));
        System.out.println(twoOutOfThree(new int[] {3,1}, new int[]{2,3}, new int[] {1,2}));
        System.out.println(twoOutOfThree(new int[] {1,2,2}, new int[] {4,3,3}, new int[] {5}));
    }
}

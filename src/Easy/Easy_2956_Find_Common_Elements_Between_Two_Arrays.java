// 2956. Find Common Elements Between Two Arrays
package Easy;
import java.util.Arrays;
import java.util.HashSet;

public class Easy_2956_Find_Common_Elements_Between_Two_Arrays {
    public static int[] findIntersectionValuesBetter(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        int[] arr1 = new int[101];
        int[] arr2 = new int[101];

        for (int num : nums1)
            arr1[num] = 1;
        for (int num : nums2)
            arr2[num] = 1;

        for (int num : nums1)
            res[0] += arr2[num];
        for (int num : nums2)
            res[1] += arr1[num];
        return res;
    }
    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1)
            set1.add(num);

        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) res[1]++;
            set2.add(num);
        }
        for (int num : nums1)
            if (set2.contains(num)) res[0]++;
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findIntersectionValues
                (new int[] {4,3,2,3,1}, new int[] {2,2,5,2,3,6})));
        System.out.println(Arrays.toString(findIntersectionValues
                (new int[] {3,4,2,3}, new int[] {1,5})));

        System.out.println(Arrays.toString(findIntersectionValuesBetter
                (new int[] {4,3,2,3,1}, new int[] {2,2,5,2,3,6})));
        System.out.println(Arrays.toString(findIntersectionValuesBetter
                (new int[] {3,4,2,3}, new int[] {1,5})));
    }
}

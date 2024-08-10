// 2215. Find the Difference of Two Arrays
package Easy;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Easy_2215_Find_the_Difference_of_Two_Arrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : nums1)
            set1.add(num);
        for (int num : nums2)
            set2.add(num);

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ans1 = new ArrayList<>(set1);
        ArrayList<Integer> ans2 = new ArrayList<>(set2);
        ans1.removeAll(set2);
        ans2.removeAll(set1);

        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
    }
}

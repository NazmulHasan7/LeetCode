// 47. Permutations II
package Medium;
import java.util.*;

public class Medium_47_Permutations_II {
    static List<List<Integer>> answer;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return answer;
    }
    private static void backtrack(List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            answer.add(new ArrayList<>(temp));
        } else {
            for (int i=0; i<nums.length; i++) {
                // Skip used elements and handle duplicates
                if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]))
                    continue;
                used[i] = true;
                temp.add(nums[i]);
                backtrack(temp, nums, used);
                used[i] = false;
                temp.removeLast();
            }
        }
    }
     public List<List<Integer>> permuteUniqueSet(int[] nums) {
         Set<List<Integer>> result = new HashSet<>();
         Arrays.sort(nums);  // Sort the array to handle duplicates
         backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
         return new ArrayList<>(result);
     }

     private void backtrack(Set<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
         if (tempList.size() == nums.length) {
             result.add(new ArrayList<>(tempList));
         } else {
             for (int i = 0; i < nums.length; i++) {
                 if (used[i]) continue;
                 used[i] = true;
                 tempList.add(nums[i]);
                 backtrack(result, tempList, nums, used);
                 used[i] = false;
                 tempList.remove(tempList.size() - 1);
             }
         }
     }
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
        System.out.println(permuteUnique(new int[]{1,2,3}));
    }
}

// 448. Find All Numbers Disappeared in an Array
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_448_Find_All_Numbers_Disappeared_in_an_Array {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // Since numbers varies from 1 to n and index ranges from 0 to n-1
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0) continue;
            nums[index] *= -1;
        }
        for (int idx=0; idx<nums.length; idx++)
            if (nums[idx] > 0) result.add(idx+1);
        return result;
    }
    public static List<Integer> findDisappearedNumbersBetter(int[] nums) {
        boolean [] visited= new boolean[nums.length+1];
        for(int i=0; i<nums.length; i++)
            visited[nums[i]] = true;

        List<Integer> ans= new ArrayList<>();
        for(int i=1; i<=nums.length; i++)
            if(!visited[i]) ans.add(i);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbers(new int[] {1,1}));
    }
}

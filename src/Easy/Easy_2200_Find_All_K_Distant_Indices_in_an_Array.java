// 2200. Find All K-Distant Indices in an Array
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_2200_Find_All_K_Distant_Indices_in_an_Array {
    // TC -> O(n^2)
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (nums[j] == key) {
                    if (Math.abs(j - i) <= k) {
                        answer.add(i);
                        break;
                    }
                }
            }
        } return answer;
    }
    // O -> O(n)
    public static List<Integer> findKDistantIndicesOpt(int[] nums, int key, int k) {
        int n = nums.length;
        ArrayList<Integer> answer = new ArrayList<>();
        int en = 0;

        for (int j=0; j<n; j++) {
            if (nums[j] == key) {
                int st = Math.max(en, j-k); // to avoid duplicate
                en = Math.min(n,j+k+1);
                for (int i=st; i<en; i++)
                    answer.add(i);
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1));
        System.out.println(findKDistantIndices(new int[]{2,2,2,2,2}, 2, 2));
        System.out.println(findKDistantIndicesOpt(new int[]{3,4,9,1,3,9,5}, 9, 1));
        System.out.println(findKDistantIndicesOpt(new int[]{2,2,2,2,2}, 2, 2));
    }
}

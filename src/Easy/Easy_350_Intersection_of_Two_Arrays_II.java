// 350. Intersection of Two Arrays II
package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class Easy_350_Intersection_of_Two_Arrays_II {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i=0, j=0; i<nums1.length &&  j<nums2.length; ) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                answer.add(nums1[i]);
                i++; j++;
            }
        }
        int[] ans = new int[answer.size()];
        int index = 0;
        for (int num : answer)
            ans[index++] = num;
        return ans;
    }
    public int[] intersectBetter(int[] nums1, int[] nums2) {
        int[] map=new int[1001];
        int[] ans=new int[1001];

        for(int i : nums1) map[i]++;
        int index=0;
        for(int i : nums2){
            if(map[i] > 0){
                ans[index++] = i;
                map[i]--;
            }
        } return Arrays.copyOfRange(ans,0,index);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[] {1,2,2,1}, new int[] {2,2})));
        System.out.println(Arrays.toString(intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
    }
}

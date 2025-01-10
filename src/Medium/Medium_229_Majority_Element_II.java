// 229. Majority Element II
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_229_Majority_Element_II {
    public static List<Integer> majorityElement(int[] nums) {
        // Only 2 numbers can have more appearance than n/3
        int ME1 = 0, ME2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (ME1 == num) {
                count1++;
            } else if (ME2 == num) {
                count2++;
            } else if (count1 == 0) {
                ME1 = num;
                count1++;
            } else if (count2 == 0) {
                ME2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        List<Integer> answer = new ArrayList<>();
        for (int num : nums) {
            if (num == ME1) count1++;
            else if (num == ME2) count2++;
        }

        if (count1 > nums.length/3) answer.add(ME1);
        if (count2 > nums.length/3) answer.add(ME2);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{1}));
        System.out.println(majorityElement(new int[]{1,2}));
    }
}

// 3289. The Two Sneaky Numbers of Digitville
package Easy;
import java.util.Arrays;

public class Easy_3289_The_Two_Sneaky_Numbers_of_Digitville {
    public static int[] getSneakyNumbers(int[] nums) {
        // HashSet<Integer> set = new HashSet<>();
        // int[] answer = new int[2];
        // int count = 0;
        // for (int n : nums) {
        //     if (!set.add(n)) {
        //         answer[count++] = n;
        //         if (count == 2) break;
        //     }
        // } return answer;

        int[] result = new int[2];
        int n = nums.length-2;
        boolean[] found = new boolean[n+2];
        int index = 0;

        for(int num:nums) {
            if (found[num]) result[index++] = num;
            else found[num]=true;
            if(index == 2) break;
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{0,1,1,0})));
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{0,3,2,1,3,2})));
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{7,1,5,4,3,4,6,0,9,5,8,2})));
    }
}

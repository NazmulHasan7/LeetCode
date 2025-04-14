// 2191. Sort the Jumbled Numbers
package Medium;
import java.util.Arrays;

public class Medium_2191_Sort_the_Jumbled_Numbers {
    // TC -> O(nlog(n)), SC -> O(n)
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mappedNumbers = new int[n][2];

        int idx = 0;
        for (int i=0; i<n; i++) {
            int mappedNum = 0;
            int temp = nums[i];
            int place = 1;

            if (temp == 0) {
                mappedNum = mapping[0];
            } else {
                while (temp != 0) {
                    mappedNum = place * mapping[temp % 10] + mappedNum;
                    place *= 10;
                    temp /= 10;
                }
            }
            mappedNumbers[idx] = new int[]{mappedNum, i};
            idx++;
        }

        Arrays.sort(mappedNumbers, (a, b) -> Integer.compare(a[0], b[0]));
        int[] answer = new int[n];
        for (int i=0; i<n; i++)
            answer[i] = nums[mappedNumbers[i][1]];

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38})));
        System.out.println(Arrays.toString(sortJumbled(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{789,456,123})));
    }
}

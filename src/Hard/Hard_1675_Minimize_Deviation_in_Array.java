// 1675. Minimize Deviation in Array
package Hard;
import java.util.TreeSet;

public class Hard_1675_Minimize_Deviation_in_Array {
    public static int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : nums) {
            if (x % 2 == 0) set.add(x);
            else set.add(x * 2);
        }
        int answer = Integer.MAX_VALUE;
        while (true) {
            int max = set.last();
            int min = set.first();
            answer = Math.min(answer, max-min);

            if (max % 2 == 0) {
                set.remove(max);
                set.add(max>>1);
            } else { // Cannot divide further because the max is an odd
                break;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(minimumDeviation(new int[]{1,2,3,4}));
        System.out.println(minimumDeviation(new int[]{4,1,5,20,3}));
        System.out.println(minimumDeviation(new int[]{2,10,8}));
    }
}

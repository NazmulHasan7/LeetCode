// 2766. Relocate Marbles
package Medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Medium_2766_Relocate_Marbles {
    public static List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        int n = moveFrom.length;
        HashSet<Integer> set = new HashSet<>();
        for (int position : nums) set.add(position);

        for (int i=0; i<n; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }

        List<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(relocateMarbles(new int[]{1,6,7,8}, new int[]{1,7,2}, new int[]{2,9,5}));
        System.out.println(relocateMarbles(new int[]{1,1,3,3}, new int[]{1,3}, new int[]{2,2}));
    }
}

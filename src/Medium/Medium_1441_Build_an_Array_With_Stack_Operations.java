// 1441. Build an Array With Stack Operations
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_1441_Build_an_Array_With_Stack_Operations {
    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int index = 0;
        for (int i=1; i<=n; i++) {
            if (target[index] == i) {
                index++;
                result.add("Push");
                if (index == target.length) break;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildArray(new int[] {1,3}, 3).toArray()));
        System.out.println(Arrays.toString(buildArray(new int[] {1,2,3}, 3).toArray()));
        System.out.println(Arrays.toString(buildArray(new int[] {1,2}, 4).toArray()));
    }
}

// 1502. Can Make Arithmetic Progression From Sequence
package Easy;
import java.util.Arrays;

public class Easy_1502_Can_Make_Arithmetic_Progression_From_Sequence {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[0] - arr[1];
        for (int i=1; i<arr.length-1; i++)
            if (arr[i] - arr[i+1] != diff)
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[] {3,5,1}));
        System.out.println(canMakeArithmeticProgression(new int[] {1,2,4}));
    }
}

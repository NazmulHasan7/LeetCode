// 989. Add to Array-Form of Integer
package Easy;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Easy_989_Add_to_Array_Form_of_Integer {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> answer = new ArrayList<>();
        int n = num.length;
        int carry = 0;

        while (n > 0 || k > 0 || carry > 0) {
            if (n > 0) {
                carry += num[--n];
            }
            if (k > 0) {
                carry += k % 10;
                k /= 10;
            }
            answer.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(answer);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{1,2,0,0}, 34));
        System.out.println(addToArrayForm(new int[]{2,7,4}, 181));
        System.out.println(addToArrayForm(new int[]{2,1,5}, 806));
    }
}

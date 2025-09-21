// 2197. Replace Non-Coprime Numbers in Array
package Hard;
import java.util.ArrayList;
import java.util.List;

public class Hard_2197_Replace_Non_Coprime_Numbers_in_Array {
    public static List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;

        for(int num:nums) {
            while(top != -1) {
                int x = gcd(stack[top], num);
                if(x == 1) break;
                num *= (int) (stack[top--] / x);
            }
            stack[++top] = num;
        }
        List<Integer> result = new ArrayList<Integer>(top + 1);
        for(int i = 0; i <= top; ++i)
            result.add(stack[i]);
        return result;
    }
    public static int gcd(int a, int b){
        return b == 0 ? a: gcd(b, a % b);
    }
    public static void main(String[] args) {
        System.out.println(replaceNonCoprimes(new int[]{6,4,3,2,7,6,2}));
        System.out.println(replaceNonCoprimes(new int[]{2,2,1,1,3,3,3}));
    }
}

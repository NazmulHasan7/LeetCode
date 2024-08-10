// 1006. Clumsy Factorial
package Medium;
import java.util.Stack;

public class Medium_1006_Clumsy_Factorial {
    public static int clumsy(int n) {
        int answer = 0;
        int op = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n--);

        while (n > 0) {
            if (op == 0) stack.push(stack.pop() * n--);
            else if (op == 1) stack.push(stack.pop() / n--);
            else if (op == 2) stack.push(n--);
            else stack.push(-1 * n--);
            op = (op + 1) % 4;
            // System.out.println("stack : " + stack);
        }
        while (!stack.isEmpty()) answer += stack.pop();
        return answer;
    }
    public static int clumsyPattern(int n) {
        if(n==1) return 1;
        if(n==4) return 7;
        if(n==3) return 6;
        if(n==2) return 2;

        if(n%4==0) return n+1;
        if(n%4==1) return n+2;
        if(n%4==2) return n+2;
        if(n%4==3) return n-1;
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(clumsy(7));
        System.out.println(clumsy(4));
    }
}

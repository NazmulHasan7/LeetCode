// 1475. Final Prices With a Special Discount in a Shop
package Easy;
import java.util.Arrays;
import java.util.Stack;

public class Easy_1475_Final_Prices_With_a_Special_Discount_in_a_Shop {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i=prices.length-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek()>prices[i])
                stack.pop();

            int price = prices[i];
            if (!stack.isEmpty())
                prices[i] = prices[i] - stack.peek();
            stack.push(price);
        } return prices;
    }
    public static int[] finalPricesBetter(int[] prices) {
        int stackPtr = -1;
        int[] stack = new int[prices.length];
        for (int i=prices.length-1; i>=0; i--) {
            while (stackPtr > -1 && stack[stackPtr] > prices[i])
                stackPtr--;

            int price = prices[i];
            if (stackPtr > -1) prices[i] -= stack[stackPtr];
            stack[++stackPtr] = price;
        } return prices;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPricesBetter(new int[] {8,4,6,2,3})));
        System.out.println(Arrays.toString(finalPricesBetter(new int[] {1,2,3,4,5})));
        System.out.println(Arrays.toString(finalPricesBetter(new int[] {10,1,1,6})));
    }
}

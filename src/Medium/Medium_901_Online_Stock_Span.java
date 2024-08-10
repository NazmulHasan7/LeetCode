// 901. Online Stock Span
package Medium;
import java.util.Stack;

public class Medium_901_Online_Stock_Span {
    static class Stock {
        int price, span;
        public Stock (int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
    static class StockSpanner {
        Stack<Stock> stack;
        public StockSpanner() {
            stack = new Stack<>();
        }
        // Monotonic Stack => Decreasing order
        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek().price <= price)
                span += stack.pop().span;
            stack.push(new Stock(price, span));
            System.out.println(span);
            return span;
        }
    }
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100); // return 1
        stockSpanner.next(80);  // return 1
        stockSpanner.next(60);  // return 1
        stockSpanner.next(70);  // return 2
        stockSpanner.next(60);  // return 1
        stockSpanner.next(75);  // return 4
        stockSpanner.next(85);  // return 6
    }
}

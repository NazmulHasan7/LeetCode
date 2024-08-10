// 1352. Product of the Last K Numbers
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_1352_Product_of_the_Last_K_Numbers {
    static class ProductOfNumbers {
        List<Integer> result;
        int prevNumber;
        public ProductOfNumbers() {
            result = new ArrayList<>();
            prevNumber = 1;
        }
        public void add(int num) {
            if (num > 0) {
                prevNumber = prevNumber * num;
                result.add(prevNumber);
            } else {
                result = new ArrayList<>();
                prevNumber = 1;
            }
        }
        public int getProduct(int k) {
            int size = result.size();
            if (size < k) return 0;
            else if (size == k) return prevNumber;
            else return prevNumber / result.get(size-1-k);
        }
    }
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);            // [3]
        productOfNumbers.add(0);            // [3,0]
        productOfNumbers.add(2);            // [3,0,2]
        productOfNumbers.add(5);            // [3,0,2,5]
        productOfNumbers.add(4);            // [3,0,2,5,4]
        productOfNumbers.getProduct(2);
        productOfNumbers.getProduct(3);
        productOfNumbers.getProduct(4);
        productOfNumbers.add(8);            // [3,0,2,5,4,8]
        productOfNumbers.getProduct(2);  // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }
}

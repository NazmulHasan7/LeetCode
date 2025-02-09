// 1726. Tuple with Same Product
package Medium;
import java.util.HashMap;

public class Medium_1726_Tuple_with_Same_Product {
    public static int tupleSameProduct(int[] nums) {
        // From a valid tuple -> 8 arrangements can be made
        // ab = cd, ab = dc, ba = cd, ba = dc
        // cd = ab, dc = ab, cd = ba, dc = ba
        int n = nums.length;
        HashMap<Integer, Integer> productMap = new HashMap<>();

        for (int a=0; a<n; a++) {
            for (int b=a+1; b<n; b++) {
                int product = nums[a] * nums[b];
                // store the frequency of product in the map
                productMap.put(product, productMap.getOrDefault(product, 0) + 1);
            }
        }

        int answer = 0;
        // We have counted the pairs that make the product
        // A tuple needs 2 pairs
        // To pick 2 pairs out of n pairs, there are ncr -> nc2 ways
        // nc2 = n! / ((n-2)!*2!) => (n*(n-1)*(n-2)!) / ((n-2)!*2!)
        // => (n*(n-1))/2
        for (int count : productMap.values()) {
            if (count > 1) {
                // answer += 8 * (count * (count-1)) / 2;
                answer += 4 * (count * (count - 1));
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2,3,4,6}));
        System.out.println(tupleSameProduct(new int[]{1,2,4,5,10}));
    }
}

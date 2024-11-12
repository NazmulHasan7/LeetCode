// 2600. K Items With the Maximum Sum
package Easy;

public class Easy_2600_K_Items_With_the_Maximum_Sum {
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int answer = 0;
        if (numOnes >= k) {
            return k;
        } else {
            answer += numOnes;
            k -= numOnes;
            if (k > numZeros) {
                k -= numZeros;
                if (k > 0) {
                    answer -= k;
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum(3,2,0,2));
        System.out.println(kItemsWithMaximumSum(3,2,0,4));
    }
}

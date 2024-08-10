// 1486. XOR Operation in an Array
package Easy;

public class Easy_1486_XOR_Operation_in_an_Array {
    public static int xorOperation(int n, int start) {
        int xorSum = start;
        for (int i=1; i<n; i++)
            xorSum = xorSum ^ (start + 2 * i);
        return xorSum;
    }
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
    }
}

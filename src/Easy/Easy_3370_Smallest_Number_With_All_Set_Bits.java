// 3370. Smallest Number With All Set Bits
package Easy;

public class Easy_3370_Smallest_Number_With_All_Set_Bits {
    public static int smallestNumber(int n) {
        /* int answer = 0;
        while (n != 0) {
            n >>= 1;
            answer |= 1;
            answer <<= 1;
        }
        answer >>= 1;
        return answer; */
        int k = 0;
        while ((1 << k) <= n) k++;
        return (1 << k) - 1;
    }
    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
        System.out.println(smallestNumber(10));
        System.out.println(smallestNumber(3));
    }
}

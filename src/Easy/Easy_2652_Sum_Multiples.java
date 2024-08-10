// 2652. Sum Multiples
package Easy;

public class Easy_2652_Sum_Multiples {
    public static int sumOfMultiples(int n) {
        int res = 0;
        for (int i=1; i<=n; i++)
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                res += i;
        return res;
    }
    public static void main(String[] args) {
        System.out.println(sumOfMultiples(10));
        System.out.println(sumOfMultiples(9));
    }
}

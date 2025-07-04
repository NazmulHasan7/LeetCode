// 3560. Find Minimum Log Transportation Cost
package Easy;

public class Easy_3560_Find_Minimum_Log_Transportation_Cost {
    public static long minCuttingCost(int n, int m, int k) {
        if (n <= k && m <= k) return 0;
        long cost = 0;
        if (m > k) cost += ((long) k * (m-k));
        if (n > k) cost += ((long) k * (n-k));
        return cost;
    }
    public static void main(String[] args) {
        System.out.println(minCuttingCost(6,5,5));
        System.out.println(minCuttingCost(4,4,6));
    }
}

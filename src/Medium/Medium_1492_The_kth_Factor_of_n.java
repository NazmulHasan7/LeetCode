// 1492. The kth Factor of n
package Medium;

public class Medium_1492_The_kth_Factor_of_n {
    public static int kthFactor(int n, int k) {
        /* ArrayList<Integer> factors = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            if (n % i == 0)
                factors.add(i);
        }
        if (k > factors.size()) return -1;
        return factors.get(k-1); */

        int factorCount = 0;
        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                factorCount++;
            }
            if (factorCount == k) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(kthFactor(12,3));
        System.out.println(kthFactor(7,2));
        System.out.println(kthFactor(4,4));
    }
}

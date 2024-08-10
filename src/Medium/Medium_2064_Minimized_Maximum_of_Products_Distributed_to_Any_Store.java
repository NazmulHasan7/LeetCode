// 2064. Minimized Maximum of Products Distributed to Any Store
package Medium;

public class Medium_2064_Minimized_Maximum_of_Products_Distributed_to_Any_Store {
    public static int minimizedMaximum(int n, int[] quantities) {
        int start = 1, end = 0, answer = 0;
        for (int q : quantities)
            end = Math.max(end, q);

        while(start <= end) {
            int mid = (start + end) / 2;
            int stores = 0;
            for (int q : quantities) {
                stores += q / mid;
                // A store can only be given at most one product type
                if (q % mid != 0) stores++;
            }
            if (stores <= n) {
                answer = mid;
                end = mid - 1;
            } else start = mid + 1;
        } return answer;
    }
    public int minimizedMaximumBetter(int n, int[] quantities) {
        int start = 1, end = 0;
        for (int quantity : quantities)
            end = Math.max(end, quantity);

        int answer = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isDistributionPossible(mid, quantities, n)) {
                answer = mid;
                end = mid - 1;
            } else start = mid + 1;
        } return answer;
    }

    private boolean isDistributionPossible(int maxProducts, int[] quantities, int stores) {
        int storeCount = 0;
        for (int quantity : quantities) {
            storeCount += quantity / maxProducts;
            if (quantity % maxProducts != 0)
                storeCount++;
            if (storeCount > stores) return false;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(minimizedMaximum(6, new int[]{11,6}));
        System.out.println(minimizedMaximum(7, new int[]{15,10,10}));
        System.out.println(minimizedMaximum(1, new int[]{100000}));
    }
}

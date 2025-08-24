// 3638. Maximum Balanced Shipments
package Medium;

public class Medium_3638_Maximum_Balanced_Shipments {
    public static int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        // int max = -1;
        int balancedShipments = 0;

        for (int i=1; i<n; i++) {
            // if (max == -1) max = weight[i];
            if (weight[i] < weight[i-1]) {
                balancedShipments++;
                i++;
                // max = -1;
            }
            // else max = Math.max(max, weight[i]);
        } return balancedShipments;
    }
    public static void main(String[] args) {
        System.out.println(maxBalancedShipments(new int[]{2,5,1,4,3}));
        System.out.println(maxBalancedShipments(new int[]{4,4}));
    }
}

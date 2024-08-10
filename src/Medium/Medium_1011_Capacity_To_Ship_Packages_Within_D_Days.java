// 1011. Capacity To Ship Packages Within D Days
package Medium;

public class Medium_1011_Capacity_To_Ship_Packages_Within_D_Days {
    public static int daysToCarry(int[] weights, int capacity) {
        int sum = 0, days = 1;
        for (int weight : weights) {
            sum += weight;
            if (sum > capacity) {
                days++;
                // A new day, Loading starts with the current container
                sum = weight;
            }
        } return days;
    }
    public static int shipWithinDays(int[] weights, int days) {
        int weightSum = 0, maxWeight = 0;
        for (int weight : weights) {
            if (weight > maxWeight)
                maxWeight = weight;
            weightSum += weight;
        }
        // Minimum weight capacity of the ship should be the maximum weight of any single package,
        // Since the ship must be able to carry at least one package.
        int minCapacity = maxWeight;
        // Maximum weight capacity of the ship should be the sum of all the package weights,
        // Since the ship must be able to carry all the packages in a single day
        int maxCapacity = weightSum;

        while (minCapacity <= maxCapacity) {
            int mid = (minCapacity + maxCapacity) / 2;
            if (daysToCarry(weights, mid) > days)
                minCapacity = mid + 1;
            else maxCapacity = mid - 1;
        }
        return minCapacity;
    }
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4},3));
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1},4));
    }
}

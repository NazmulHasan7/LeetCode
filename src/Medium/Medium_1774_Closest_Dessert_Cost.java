// 1774. Closest Dessert Cost
package Medium;

public class Medium_1774_Closest_Dessert_Cost {
    private static int cost;
    private static int minDiff;

    // TC -> O(n * 3^m)
    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        cost = Integer.MAX_VALUE;
        minDiff = Integer.MAX_VALUE;
        for (int base : baseCosts) // O(n)
            dfs(toppingCosts, 0, base, target); // O(3^m)
        return cost;
    }
    private static void dfs(int[] toppings, int idx, int currCost, int target) {
        int costDiff = Math.abs(target - currCost);
        if (costDiff < minDiff || (costDiff == minDiff && currCost < cost)) {
            minDiff = costDiff;
            cost = currCost;
        }

        if (idx == toppings.length || currCost >= target) return;

        dfs(toppings, idx+1, currCost, target); // skip the topping
        dfs(toppings, idx+1, currCost+toppings[idx], target); // add this topping
        dfs(toppings, idx+1, currCost+toppings[idx]*2, target); // add this topping twice
    }
    public static void main(String[] args) {
        System.out.println(closestCost(new int[]{1,7}, new int[]{3,4}, 10));
        System.out.println(closestCost(new int[]{2,3}, new int[]{4,5,100}, 18));
        System.out.println(closestCost(new int[]{3,10}, new int[]{2,5}, 9));
    }
}

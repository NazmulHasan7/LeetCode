// 1333. Filter Restaurants by Vegan-Friendly, Price and Distance
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_1333_Filter_Restaurants_by_Vegan_Friendly_Price_and_Distance {
    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> eligibleRestaurants = new ArrayList<>();

        for (int[] restaurant : restaurants) {
            if ((restaurant[2] == 1 || veganFriendly == 0) && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance)
                eligibleRestaurants.add(restaurant);
        }
        eligibleRestaurants.sort((r1, r2) -> {
            if (r1[1] == r2[1])
                return r2[0] - r1[0];  // Higher ID first if ratings are equal
            return r2[1] - r1[1];      // Higher rating first
        });
        List<Integer> answer = new ArrayList<>();
        for (int[] res : eligibleRestaurants)
            answer.add(res[0]);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(filterRestaurants(new int[][]{
                {1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}
        },1,50,10));
    }
}

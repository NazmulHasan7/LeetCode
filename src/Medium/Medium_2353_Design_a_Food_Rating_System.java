// 2353. Design a Food Rating System
package Medium;
import java.util.HashMap;
import java.util.TreeSet;

public class Medium_2353_Design_a_Food_Rating_System {
    static class Food {
        String name;
        String cuisine;
        int rating;
        Food (String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
    static class FoodRatings {
        private HashMap<String, Food> foodMap;
        // Cuisine -> Rating (Sorted in Descending order)
        private HashMap<String, TreeSet<Food>> cuisineRating;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            // initialization
            foodMap = new HashMap<>();
            cuisineRating = new HashMap<>();

            // populate the maps
            int n = foods.length;
            for (int i=0; i<n; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                foodMap.put(foods[i], food);

                cuisineRating.computeIfAbsent(
                        cuisines[i], k -> new TreeSet<>((food1, food2) -> {
                            // If there is a tie, return the item with the lexicographically smaller name
                            if (food1.rating == food2.rating)
                                return food1.name.compareTo(food2.name);
                            return food2.rating - food1.rating;
                        })
                ).add(food); // O(log N)
            }
        }

        public void changeRating(String food, int newRating) {
            Food f = foodMap.get(food);
            cuisineRating.get(f.cuisine).remove(f);
            f.rating = newRating;
            cuisineRating.get(f.cuisine).add(f);
        }

        public String highestRated(String cuisine) {
            return cuisineRating.get(cuisine).first().name;
        }
    }
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7}
        );
        foodRatings.highestRated("korean");
        foodRatings.highestRated("japanese");
        foodRatings.changeRating("sushi", 16);
        foodRatings.highestRated("japanese");
        foodRatings.changeRating("ramen", 16);
        foodRatings.highestRated("japanese");
    }
}

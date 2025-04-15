// 1418. Display Table of Food Orders in a Restaurant
package Medium;
import java.util.*;

public class Medium_1418_Display_Table_of_Food_Orders_in_a_Restaurant {
    // n = number of orders, f = number of unique foods, t = number of unique tables
    // TC -> O(n log(f) + n log(t) + O(t * f)
    // SC -> foods O(f), tables O(t), map O(t*f)[worst], answer O(t*f)
    public static List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> foods = new TreeSet<>();
        TreeSet<Integer> tables = new TreeSet<>();

        // Map table number to a map of food -> count
        HashMap<Integer, Map<String, Integer>> tableFoodMap = new HashMap<>();

        for (List<String> order : orders) { // O(n log(f) + n log(t))
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            foods.add(food); // log(f)
            tables.add(table); // log(t)

            Map<String, Integer> foodCount = tableFoodMap.computeIfAbsent(table, k -> new HashMap<>());
            foodCount.put(food, foodCount.getOrDefault(food,0) + 1);
        }

        List<List<String>> answer = new ArrayList<>();
        answer.add(new ArrayList<>()); // Header
        answer.getFirst().add("Table");
        answer.getFirst().addAll(foods); // O(f)

        for (int table : tables) { // O(t * f)
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(table));
            Map<String, Integer> foodCounts = tableFoodMap.get(table);

            for (String food : foods) // O(t)
                row.add(String.valueOf(foodCounts.getOrDefault(food, 0)));

            answer.add(row);
        }
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        orders.add(List.of("David","3","Ceviche"));
        orders.add(List.of("Corina","10","Beef Burrito"));
        orders.add(List.of("David","3","Fried Chicken"));
        orders.add(List.of("Carla","5","Water"));
        orders.add(List.of("Carla","5","Ceviche"));
        orders.add(List.of("Rous","3","Ceviche"));
        System.out.println(displayTable(orders));
    }
}

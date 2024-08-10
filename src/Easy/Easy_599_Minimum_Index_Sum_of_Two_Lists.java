// 599. Minimum Index Sum of Two Lists
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Easy_599_Minimum_Index_Sum_of_Two_Lists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        int indexSum = Integer.MAX_VALUE;
        int sum;
        for (int i=0; i<list1.length; i++) {
            for (int j=0; j<list2.length; j++) {
                sum = i+j;
                if (sum < indexSum && list1[i].equals(list2[j])) {
                    result.clear();
                    result.add(list1[i]);
                    indexSum = sum;
                } else if (sum == indexSum && list1[i].equals(list2[j]))
                    result.add(list1[i]);
            }
        } return result.toArray(new String[0]);
    }
    public static String[] findRestaurantBetter(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        int indexSum = Integer.MAX_VALUE;
        int sum;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<list1.length; i++)
            map.put(list1[i], i);

        int index;
        for (int j=0; j<list2.length && j<=indexSum; j++) {
            index = map.getOrDefault(list2[j], -1);
            if (index != -1) {
                sum = index + j;
                if (sum < indexSum) {
                    result.clear();
                    result.add(list2[j]);
                    indexSum = sum;
                } else if (sum == indexSum) result.add(list2[j]);
            }
        } return result.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRestaurant(
                new String[] {"Shogun","Tapioca Express","Burger King","KFC"},
                new String[] {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"})));
        System.out.println(Arrays.toString(findRestaurant(
                new String[] {"Shogun","Tapioca Express","Burger King","KFC"},
                new String[] {"KFC","Shogun","Burger King"})));
        System.out.println(Arrays.toString(findRestaurant(
                new String[] {"happy","sad","good"},
                new String[] {"sad","happy","good"})));
        System.out.println(Arrays.toString(findRestaurantBetter(
                new String[] {"Shogun","Tapioca Express","Burger King","KFC"},
                new String[] {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"})));
        System.out.println(Arrays.toString(findRestaurantBetter(
                new String[] {"Shogun","Tapioca Express","Burger King","KFC"},
                new String[] {"KFC","Shogun","Burger King"})));
        System.out.println(Arrays.toString(findRestaurantBetter(
                new String[] {"happy","sad","good"},
                new String[] {"sad","happy","good"})));
    }
}

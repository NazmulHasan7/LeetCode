// 904. Fruit Into Baskets
package Medium;
import java.util.HashMap;

public class Medium_904_Fruit_Into_Baskets {
    // Actual Problem -> Find the longest contagious sub-array with 2 distinct elements
    public static int totalFruit(int[] fruits) {
        int answer = 0, left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right=0; right<fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            // Whenever a new type of fruit is found keep pooping from the left until the map size is 2 again
            while (map.size() > 2) {
                map.put(fruits[left], map.getOrDefault(fruits[left], 0)-1);
                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            } answer = Math.max(answer, right-left+1);
        } return answer;
    }
    public static int totalFruitBetter(int[] fruits) {
        int answer = 0, left = 0, right = 0, types = 0;
        int[] freq = new int[fruits.length];

        while (right < fruits.length) {
            if (freq[fruits[right]] == 0)
                types++;
            freq[fruits[right]]++;

            while (types > 2) {
                freq[fruits[left]]--;
                if (freq[fruits[left]] == 0)
                    types--;
                left++;
            }
            answer = Math.max(answer, right-left+1);
            right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(totalFruitBetter(new int[]{1,2,1}));
        System.out.println(totalFruitBetter(new int[]{0,1,2,2}));
        System.out.println(totalFruitBetter(new int[]{1,2,3,2,2}));
    }
}

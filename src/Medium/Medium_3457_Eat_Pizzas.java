// 3457. Eat Pizzas!
package Medium;
import java.util.Arrays;

public class Medium_3457_Eat_Pizzas {
    public static long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);

        int n = pizzas.length;
        int totalDays = n/4;
        int oddDays = (totalDays + 1) / 2;
        int evenDays = totalDays / 2;
        long weight = 0;
        int last = n-1; // keep track of the highest weight pizza

        // for odd days - eat the pizza with the highest weight
        while (oddDays > 0) {
            oddDays--;
            weight += pizzas[last];
            last--;
        }
        // for even days - eat the pizza with the second-highest weight
        while (evenDays > 0) {
            evenDays--;
            weight += pizzas[last-1];
            last -= 2;
        }
        return weight;
    }
    public static void main(String[] args) {
        System.out.println(maxWeight(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(maxWeight(new int[]{2,1,1,1,1,1,1,1}));
    }
}

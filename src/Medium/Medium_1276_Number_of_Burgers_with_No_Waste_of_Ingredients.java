// 1276. Number of Burgers with No Waste of Ingredients
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_1276_Number_of_Burgers_with_No_Waste_of_Ingredients {
    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> answer = new ArrayList<>();

        if (cheeseSlices > tomatoSlices)
            return answer; // cannot make tomato slices 0

        if ((tomatoSlices & 1) != 0)
            return answer; // cannot make tomato slices 0

        // Equations
        // 4 * jumbo + 2 * small = tomato
        // jumbo + small = cheese => small = cheese - jumbo
        // 4 * jumbo + 2 * cheese - 2 * jumbo = tomato
        // 2 * jumbo = tomato - 2 * cheese

        int jumbo = (tomatoSlices - 2 * cheeseSlices) / 2;
        int small = cheeseSlices - jumbo;

        tomatoSlices -= (4 * jumbo + 2 * small);
        cheeseSlices -= jumbo + small;

        if (tomatoSlices == 0 && cheeseSlices == 0 && jumbo >= 0 && small >= 0) {
            answer.add(jumbo);
            answer.add(small);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(numOfBurgers(16, 7));
        System.out.println(numOfBurgers(17, 4));
        System.out.println(numOfBurgers(4, 17));
    }
}

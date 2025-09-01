// 2848. Points That Intersect With Cars
package Easy;
import java.util.List;

public class Easy_2848_Points_That_Intersect_With_Cars {
    public static int numberOfPoints(List<List<Integer>> nums) {
        int[] line = new int[102];
        for (List<Integer> coordinate : nums) {
            line[coordinate.get(0)]++; // start of a car
            line[coordinate.get(1)+1]--; // end of a car
        }

        int countOfCars = 0;
        int points = 0;
        for (int val : line) {
            countOfCars += val;
            if (countOfCars > 0) // there is at least one car
                points++;
        }
        return points;
    }
    public static void main(String[] args) {
        System.out.println(numberOfPoints(List.of(List.of(3,6), List.of(1,5), List.of(4,7))));
        System.out.println(numberOfPoints(List.of(List.of(1,3), List.of(5,8))));
    }
}

// 624. Maximum Distance in Arrays
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_624_Maximum_Distance_in_Arrays {
    public static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).getLast();

        int maxDistance = 0;
        for (int i=1; i<arrays.size(); i++) {
            int currentMin = arrays.get(i).get(0);
            int currentMax = arrays.get(i).getLast();

            maxDistance = Math.max(maxDistance, Math.abs(max - currentMin));
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - min));

            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
        }
        return maxDistance;
    }
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(new ArrayList<>(List.of(1,2,3)));
        arrays.add(new ArrayList<>(List.of(4,5)));
        arrays.add(new ArrayList<>(List.of(1,2,3)));
        System.out.println(maxDistance(arrays));
    }
}

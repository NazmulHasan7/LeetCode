// 1282. Group the People Given the Group Size They Belong To
package Medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium_1282_Group_the_People_Given_the_Group_Size_They_Belong_To {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int people=0; people<groupSizes.length; people++) {
            List<Integer> group = map.getOrDefault(groupSizes[people], new ArrayList<>());
            group.add(people);
            if (group.size() == groupSizes[people]) {
                result.add(group);
                map.remove(groupSizes[people]);
            } else {
                map.put(groupSizes[people], group);
            }
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[] {3,3,3,3,3,1,3}));
        System.out.println(groupThePeople(new int[] {2,1,3,3,3,2}));
    }
}

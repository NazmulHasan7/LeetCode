// 1436. Destination City
package Easy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Easy_1436_Destination_City {
    public static String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        for (List<String> path : paths)
            set.add(path.get(0));
        for (List<String> path : paths)
            if (!set.contains(path.get(1)))
                return path.get(1);
        return "";
    }
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of("London", "New York")));
        list.add(new ArrayList<>(List.of("New York", "Lima")));
        list.add(new ArrayList<>(List.of("Lima", "Sao Paulo")));
        System.out.println(destCity(list));
    }
}

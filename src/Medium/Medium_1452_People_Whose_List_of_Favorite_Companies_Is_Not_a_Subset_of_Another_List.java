// 1452. People Whose List of Favorite Companies Is Not a Subset of Another List
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Medium_1452_People_Whose_List_of_Favorite_Companies_Is_Not_a_Subset_of_Another_List {
    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> answer = new ArrayList<>();
        int n = favoriteCompanies.size();

        for (int i=0; i<n; i++) {
            boolean isSubset = false;
            for (int j=0; j!=i && j<n; j++) {
                HashSet<String> setA = new HashSet<>(favoriteCompanies.get(i));
                HashSet<String> setB = new HashSet<>(favoriteCompanies.get(j));
                setA.removeAll(setB);
                if (setA.isEmpty()) {
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) answer.add(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(peopleIndexes(Arrays.asList(Arrays.asList("leetcode","google","facebook"), Arrays.asList("google","microsoft"),
                Arrays.asList("google","facebook"), List.of("google"), List.of("amazon"))));
    }
}

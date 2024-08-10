// 1773. Count Items Matching a Rule
package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class Easy_1773_Count_Items_Matching_a_Rule {
    public static int countMatches(ArrayList<ArrayList<String>> items, String ruleKey, String ruleValue) {
        int k;
        if (ruleKey.equals("type")) k = 0;
        else if (ruleKey.equals("color")) k = 1;
        else k = 2;
        int count = 0;
        int n = items.size();
        for (int i=0; i<n; i++)
            if (items.get(i).get(k).equals(ruleValue))
                count++;
        return count;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> items = new ArrayList<>();
        items.add(new ArrayList<>(Arrays.asList("phone", "blue", "pixel")));
        items.add(new ArrayList<>(Arrays.asList("computer", "silver", "lenovo")));
        items.add(new ArrayList<>(Arrays.asList("phone", "gold", "iphone")));
        System.out.println(countMatches(items, "color", "silver"));
    }
}
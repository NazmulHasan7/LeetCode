// 884. Uncommon Words from Two Sentences
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Easy_884_Uncommon_Words_from_Two_Sentences {
    public static String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : s1.split(" "))
            map.put(str, map.getOrDefault(str, 0)+1);
        for (String str : s2.split(" "))
            map.put(str, map.getOrDefault(str, 0)+1);

        ArrayList<String> list = new ArrayList<>();
        for (String str : map.keySet())
            if (map.get(str) == 1)
                list.add(str);
        return list.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(uncommonFromSentences("apple apple", "banana")));
    }
}

// 3527. Find the Most Common Response
package Medium;
import java.util.*;

public class Medium_3527_Find_the_Most_Common_Response {
    public static String findCommonResponse(List<List<String>> responses) {
        HashMap<String, Integer> map = new HashMap<>();

        for (List<String> response : responses) {
            Set<String> set = new HashSet<>(response);
            for (String str : set)
                map.put(str, map.getOrDefault(str, 0) + 1);
        }

        String answer = "";
        int maxFreq = 0;

        for (String key : map.keySet()) {
            int freq = map.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
                answer = key;
            } else if (freq == maxFreq) {
                if (key.compareTo(answer) < 0)
                    answer = key;
            }
        } return answer;
    }
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("good", "ok", "good", "ok"));
        list.add(Arrays.asList("ok", "bad", "good", "ok", "ok"));
        list.add(List.of("good"));
        list.add(List.of("bad"));
        System.out.println(findCommonResponse(list));
    }
}

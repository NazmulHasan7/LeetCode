// 692. Top K Frequent Words
package Medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Medium_692_Top_K_Frequent_Words {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<String> maxHeap = new PriorityQueue<>(
                (a,b) -> {
                    if (map.get(a) == map.get(b)) return a.compareTo(b);
                    return map.get(b) - map.get(a);
                }
        );
        maxHeap.addAll(map.keySet());

        List<String> answer = new ArrayList<>();
        while (k-- > 0)
            answer.add(maxHeap.poll());
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
        System.out.println(topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }
}

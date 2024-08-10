// 981. Time Based Key-Value Store
package Medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Medium_981_Time_Based_Key_Value_Store {
    static class Pair {
        String value;
        int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    static class TimeMap {
        HashMap<String, List<Pair>> map;
        public TimeMap() {
            map = new HashMap<>();
        }
        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(new Pair(value, timestamp));
        }
        public String get(String key, int timestamp) {
            String answer = "";
            List<Pair> values = map.getOrDefault(key, new ArrayList<>());

            int start = 0, end = values.size() - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                Pair p = values.get(mid);
                if (p.timestamp <= timestamp) {
                    answer = p.value;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } return answer;
        }
    }
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        timeMap.get("foo", 1);
        timeMap.get("foo", 3);
        timeMap.set("foo", "bar2", 4);
        timeMap.get("foo", 4);
        timeMap.get("foo", 5);
    }
}

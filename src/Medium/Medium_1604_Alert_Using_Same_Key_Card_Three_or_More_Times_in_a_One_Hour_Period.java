// 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
package Medium;
import java.util.*;

public class Medium_1604_Alert_Using_Same_Key_Card_Three_or_More_Times_in_a_One_Hour_Period {
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        // {name, minHeap of integers}
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            String name = keyName[i];
            String[] time = keyTime[i].split(":");
            int timeValue = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            map.computeIfAbsent(name, k -> new ArrayList<>()).add(timeValue);
        }

        TreeSet<String> names = new TreeSet<>();
        for (String name : map.keySet()) {
            List<Integer> list = map.get(name);
            Collections.sort(list);

            for (int i=0; i<list.size()-2; i++) {
                if (list.get(i + 2) - list.get(i) <= 60) {
                    names.add(name);
                    break;
                }
            }
        } return new ArrayList<>(names);
    }
    public static void main(String[] args) {
        System.out.println(alertNames(new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"},
                new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}));
        System.out.println(alertNames(new String[]{"alice","alice","alice","bob","bob","bob","bob"},
                new String[]{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"}));
    }
}

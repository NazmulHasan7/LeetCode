// 2933. High-Access Employees
package Medium;
import java.util.*;

public class Medium_2933_High_Access_Employees {
    public static List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (List<String> accessTime : access_times) {
            String employee = accessTime.getFirst();
            String time = accessTime.getLast();
            int timeInMinute = Integer.parseInt(time.substring(0, 2)) * 60
                    + Integer.parseInt(time.substring(2, 4));
            map.computeIfAbsent(employee, k -> new ArrayList<>()).add(timeInMinute);
        }

        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            Collections.sort(times);

            for (int i=0; i<times.size()-2; i++) {
                if (times.get(i+2) - times.get(i) < 60) {
                    answer.add(name);
                    break;
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        List<List<String>> accessTimes = new ArrayList<>();
        accessTimes.add(Arrays.asList("a", "0549"));
        accessTimes.add(Arrays.asList("b", "0457"));
        accessTimes.add(Arrays.asList("a", "0532"));
        accessTimes.add(Arrays.asList("a", "0621"));
        accessTimes.add(Arrays.asList("b", "0540"));
        System.out.println(findHighAccessEmployees(accessTimes));
    }
}

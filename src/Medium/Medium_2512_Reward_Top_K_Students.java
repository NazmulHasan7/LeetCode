// 2512. Reward Top K Students
package Medium;
import java.util.*;

public class Medium_2512_Reward_Top_K_Students {
    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> pos = new HashSet<>(Arrays.asList(positive_feedback));
        HashSet<String> neg = new HashSet<>(Arrays.asList(negative_feedback));

        int n = report.length;
        PriorityQueue<int[]> students = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // sort by id
            return b[0] - a[0]; // sort by points
        });

        for (int i=0; i<n; i++) {
            String[] feedback = report[i].split(" ");
            int sId = student_id[i];
            int points = 0;
            for (String word : feedback) {
                if (pos.contains(word)) points += 3;
                else if (neg.contains(word)) points -= 1;
            }
            students.add(new int[]{points, sId});
        }
        List<Integer> answer = new ArrayList<>();
        while (k-- > 0)
            answer.add(Objects.requireNonNull(students.poll())[1]);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(topStudents(new String[]{"smart","brilliant","studious"}, new String[]{"not"},
                new String[]{"this student is studious","the student is smart"}, new int[]{1,2},2));
    }
}

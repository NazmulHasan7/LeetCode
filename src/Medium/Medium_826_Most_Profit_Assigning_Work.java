// 826. Most Profit Assigning Work
package Medium;
import java.util.Arrays;

public class Medium_826_Most_Profit_Assigning_Work {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // Need to sort the profit array while updating the difficulty array as well
        int[][] jobs = new int[profit.length][2];
        for (int i=0; i<profit.length; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        // Reverse sort the jobs array
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);
        // Sort the worker array
        Arrays.sort(worker);

        int answer = 0;
        int wk = worker.length-1;
        for (int[] job : jobs) {
            while (wk >= 0 && worker[wk] >= job[0]) {
                // System.out.println(worker[wk] + " " + job[0] + " " + job[1]);
                answer += job[1];
                wk--;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{2,4,6,8,10},
                new int[]{10,20,30,40,50}, new int[]{4,5,6,7}));
        System.out.println(maxProfitAssignment(new int[]{85,47,57},
                new int[]{24,66,99}, new int[]{40,25,25}));
    }
}

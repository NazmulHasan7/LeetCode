// 3522. Calculate Score After Performing Instructions
package Medium;

public class Medium_3522_Calculate_Score_After_Performing_Instructions {
    public static long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int n = instructions.length;
        boolean[] visited = new boolean[n];
        int idx = 0;

        while (idx >= 0 && idx < n && !visited[idx]) {
            String inst = instructions[idx];
            visited[idx] = true;
            if (inst.equals("add")) {
                score += values[idx];
                idx++;
            } else idx += values[idx];
        }
        return score;
    }
    public static void main(String[] args) {
        System.out.println(calculateScore(new String[]{"jump","add","add","jump","add","jump"},
                new int[]{2,1,3,1,-2,-3}));
        System.out.println(calculateScore(new String[]{"jump","add","add"}, new int[]{3,1,1}));
    }
}

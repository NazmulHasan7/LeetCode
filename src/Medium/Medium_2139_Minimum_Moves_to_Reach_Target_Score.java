// 2139. Minimum Moves to Reach Target Score
package Medium;

public class Medium_2139_Minimum_Moves_to_Reach_Target_Score {
    public static int minMoves(int target, int maxDoubles) {
        int count = 0;

        while (target != 1 && maxDoubles > 0) {
            if (target % 2 == 0) {
                count++;
                target /= 2;
                maxDoubles--;
            } else {
                count++;
                target--;
            }
        }
        return target == 1 ? count : count + (target - 1);
    }
    public static void main(String[] args) {
        System.out.println(minMoves(5,0));
        System.out.println(minMoves(19,2));
        System.out.println(minMoves(10,4));
    }
}

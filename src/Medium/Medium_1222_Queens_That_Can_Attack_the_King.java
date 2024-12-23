// 1222. Queens That Can Attack the King
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_1222_Queens_That_Can_Attack_the_King {
    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] qPos = new int[8][8];
        for (int[] queen : queens)
            qPos[queen[0]][queen[1]] = 1;

        List<List<Integer>> answer = new ArrayList<>();
        // Attack areas -> up, down, left, right, both diagonal

        int r = king[0];
        int c = king[1];
        while (--r >= 0) { // direction left
            if (qPos[r][c] == 1) {
                answer.add(List.of(r,c));
                break;
            }
        }
        r = king[0];
        c = king[1];
        while (++r < 8) { // direction right
            if (qPos[r][c] == 1) {
                answer.add(List.of(r,c));
                break;
            }
        }
        r = king[0];
        c = king[1];
        while (--c >= 0) { // direction up
            if (qPos[r][c] == 1) {
                answer.add(List.of(r,c));
                break;
            }
        }
        r = king[0];
        c = king[1];
        while (++c < 8) { // direction down
            if (qPos[r][c] == 1) {
                answer.add(List.of(r,c));
                break;
            }
        }
        r = king[0];
        c = king[1];
        while (--r >= 0 && --c >= 0) { // direction up-left
            if (qPos[r][c] == 1) {
                answer.add(List.of(r,c));
                break;
            }
        }
        r = king[0];
        c = king[1];
        while (++r < 8 && ++c < 8) { // direction down-right
            if (qPos[r][c] == 1) {
                answer.add(List.of(r,c));
                break;
            }
        }
        r = king[0];
        c = king[1];
        while (--r >= 0 && ++c < 8) { // direction up-right
            if (qPos[r][c] == 1) {
                answer.add(List.of(r,c));
                break;
            }
        }
        r = king[0];
        c = king[1];
        while (++r < 8 && --c >= 0) { // direction down-left
            if (qPos[r][c] == 1) {
                answer.add(List.of(r,c));
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(queensAttacktheKing(new int[][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}}, new int[]{0,0}));
    }
}

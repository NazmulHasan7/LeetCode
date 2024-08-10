// 2833. Furthest Point From Origin
package Easy;

public class Easy_2833_Furthest_Point_From_Origin {
    public static int furthestDistanceFromOrigin(String moves) {
        int countL = 0, countR = 0, countSpace = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') countL++;
            else if (c == 'R') countR++;
            else countSpace++;
        } return Math.abs(countL - countR) + countSpace;
    }
    public static void main(String[] args) {
        System.out.println(furthestDistanceFromOrigin("L_RL__R"));
        System.out.println(furthestDistanceFromOrigin("_R__LL_"));
        System.out.println(furthestDistanceFromOrigin("_______"));
    }
}

// 657. Robot Return to Origin
package Easy;

public class Easy_657_Robot_Return_to_Origin {
    public static boolean judgeCircle(String moves) {
        int h = 0, v = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U' : v++; break;
                case 'D' : v--; break;
                case 'R' : h++; break;
                case 'L' : h--; break;
            }
        } return h == 0 && v == 0;
    }
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
    }
}

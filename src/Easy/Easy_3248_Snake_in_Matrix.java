// 3248. Snake in Matrix
package Easy;
import java.util.Arrays;
import java.util.List;

public class Easy_3248_Snake_in_Matrix {
    public static int finalPositionOfSnake(int n, List<String> commands) {
        int positionR = 0;
        int positionC = 0;
        for (String command : commands) {
            if (command.equals("UP"))
                positionR += (positionR > 0) ? -1 : 0;
            else if (command.equals("DOWN"))
                positionR += (positionR < n-1) ? 1 : 0;
            else if (command.equals("RIGHT"))
                positionC += (positionC < n-1) ? 1 : 0;
            else if (command.equals("LEFT"))
                positionC += (positionC > 0) ? -1 : 0;
        }
        return positionR * n + positionC;
    }
    public static void main(String[] args) {
        System.out.println(finalPositionOfSnake(2, Arrays.asList(new String[]{"RIGHT","DOWN"})));
        System.out.println(finalPositionOfSnake(3, Arrays.asList(new String[]{"DOWN","RIGHT","UP"})));
        System.out.println(finalPositionOfSnake(2, Arrays.asList(new String[]{"RIGHT","LEFT"})));
    }
}

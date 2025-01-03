// 386. Lexicographical Numbers
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_386_Lexicographical_Numbers {
    private static List<Integer> answer;
    public static List<Integer> lexicalOrder(int n) {
        answer = new ArrayList<>();
        for (int i=1; i<10; i++)
            solve(i, n);
        return answer;
    }
    private static void solve(int number, int n) {
        if (number > n) return;
        answer.add(number);
        number = number * 10;

        for (int i=0; i<10; i++)
            if (number + i < n)
                solve(number + i, n);
    }
    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
        System.out.println(lexicalOrder(2));
    }
}

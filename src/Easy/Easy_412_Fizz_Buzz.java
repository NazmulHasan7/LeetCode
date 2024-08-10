// 412. Fizz Buzz
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_412_Fizz_Buzz {
    public static List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) list.add("FizzBuzz");
                else list.add("Fizz");
            } else if (i % 5 == 0) list.add("Buzz");
            else list.add(Integer.toString(i));
        } return list;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fizzBuzz(3).toArray()));
        System.out.println(Arrays.toString(fizzBuzz(5).toArray()));
        System.out.println(Arrays.toString(fizzBuzz(15).toArray()));
    }
}

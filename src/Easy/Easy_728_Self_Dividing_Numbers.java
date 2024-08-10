// 728. Self Dividing Numbers
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_728_Self_Dividing_Numbers {
    public static boolean isSelfDividing(int number) {
        int tempNumber = number, digit;
        while (tempNumber != 0) {
            digit = tempNumber % 10;
            if (digit == 0 || number % digit != 0) return false;
            tempNumber /= 10;
        } return true;
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num=left; num<=right; num++)
            if (isSelfDividing(num)) list.add(num);
        return list;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selfDividingNumbers(1, 22).toArray()));
        System.out.println(Arrays.toString(selfDividingNumbers(47, 85).toArray()));
        System.out.println(Arrays.toString(selfDividingNumbers(66, 708).toArray()));
    }
}

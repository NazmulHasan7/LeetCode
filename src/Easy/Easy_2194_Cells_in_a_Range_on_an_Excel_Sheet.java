// 2194. Cells in a Range on an Excel Sheet
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_2194_Cells_in_a_Range_on_an_Excel_Sheet {
    public static List<String> cellsInRange(String s) {
        char rowStart = s.charAt(1), rowEnd = s.charAt(4);
        char colStart = s.charAt(0), colEnd = s.charAt(3);
        List<String> list = new ArrayList<>();
        for (char i=colStart; i<=colEnd; i++)
            for (char j=rowStart; j<=rowEnd; j++)
                list.add(String.valueOf(new char[] {i, j}));
        return list;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(cellsInRange("K1:L2").toArray()));
        System.out.println(Arrays.toString(cellsInRange("A1:F1").toArray()));
    }
}

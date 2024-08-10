// 118. Pascal's Triangle
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_118_Pascals_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i=1; i<numRows; i++) {
            List<Integer> lastRow = triangle.get(i-1);
            List<Integer> newRow = new ArrayList<>();

            newRow.add(1);
            for (int k=1; k<i; k++)
                newRow.add(lastRow.get(k-1) + lastRow.get(k));
            newRow.add(1);
            triangle.add(newRow);
        } return triangle;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        for (List<Integer> row : result)
            System.out.println(Arrays.toString(row.toArray()));
    }
}

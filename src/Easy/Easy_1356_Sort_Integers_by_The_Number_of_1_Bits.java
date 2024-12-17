// 1356. Sort Integers by The Number of 1 Bits
package Easy;
import java.util.Arrays;
import java.util.Comparator;

public class Easy_1356_Sort_Integers_by_The_Number_of_1_Bits {
    private static int setBitCount(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
    public static int[] sortByBits(int[] arr) {
        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int bits_a = setBitCount(a);
                int bits_b = setBitCount(b);
                if (bits_a == bits_b) return Integer.compare(a, b);
                return Integer.compare(bits_a, bits_b);
            }
        });
        return Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1})));
    }
}

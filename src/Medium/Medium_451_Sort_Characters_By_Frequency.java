// 451. Sort Characters By Frequency
package Medium;
import java.util.Arrays;
import java.util.Comparator;

public class Medium_451_Sort_Characters_By_Frequency {
    public static String frequencySort(String s) {
        // Character [a-z][A-Z][0-9], Count
        int[][] freqArr = new int[128][2];

        for (char c : s.toCharArray())
            freqArr[c][0]++;

        for (int i=0; i<128; i++)
            freqArr[i][1] = i;

        Arrays.sort(freqArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<128; i++) {
            char c = (char) freqArr[i][1];
            while (freqArr[i][0]-- > 0)
                answer.append(c);
        } return new String(answer);
    }
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("Aabb"));
    }
}

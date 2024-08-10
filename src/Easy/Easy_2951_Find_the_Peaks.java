// 2951. Find the Peaks
package Easy;
import java.util.List;
import java.util.ArrayList;

public class Easy_2951_Find_the_Peaks {
    public static List<Integer> findPeaks(int[] mountain) {
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i=1; i<mountain.length-1; i++) {
            if (mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1])
                peaks.add(i);
        } return peaks;
    }
    public static void main(String[] args) {
        List<Integer> res = findPeaks(new int[] {2,4,4});
        System.out.println(res);
        res = findPeaks(new int[] {1,4,3,8,5});
        System.out.println(res);
    }
}

// 1792. Maximum Average Pass Ratio
package Medium;
import java.util.PriorityQueue;

public class Medium_1792_Maximum_Average_Pass_Ratio {
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        // MaxHeap sorted based on gain (before avg - after avg)
        // to see which class has the better impact of adding the extra students
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
                (a,b) -> Double.compare(b[0], a[0]));

        for (int[] cls : classes) {
            int passed = cls[0];
            int total = cls[1];
            double gain = calculateGain(passed, total);
            maxHeap.add(new double[]{gain, passed, total});
        }
        while (extraStudents > 0) {
            double[] cls = maxHeap.poll();
            cls[1]++;
            cls[2]++;
            cls[0] = calculateGain((int)cls[1], (int)cls[2]);
            maxHeap.add(cls);
            extraStudents--;
        }
        double passRate = 0;
        for (double[] cls : maxHeap)
            passRate += (cls[1] / cls[2]);

        return passRate / classes.length;
    }
    private static double calculateGain(int passed, int total) {
        double before = (double) passed / total;
        double after = (double) (passed+1) / (total+1);
        return after - before;
    }
    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}}, 2));
        System.out.println(maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}}, 4));
    }
}

// 2594. Minimum Time to Repair Cars
package Medium;

public class Medium_2594_Minimum_Time_to_Repair_Cars {
    public static long repairCars(int[] ranks, int cars) {
        int max = 0;
        for (int rank : ranks)
            max = Math.max(max, rank);

        long start = 1, answer = 0;
        long end = (long) max * cars * cars;
        while (start <= end) {
            long mid = start + (end - start) / 2;

            long count = 0;
            for (int rank : ranks)
                // time = r * n2 => n2 = time / r => n = Math.sqrt(time / r)
                count += (long) Math.sqrt((double) mid / rank);

            if (count >= cars) {
                answer = mid;
                end = mid - 1;
            } else start = mid + 1;
        } return answer;
    }
    public static long repairCarsBetter(int[] ranks, int cars) {
        long minRank = ranks[0];
        int[] freq = new int[101];
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
            freq[rank]++;
        }
        long start = 1, end = minRank * cars * cars;
        long answer = end;
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int i = 1; i < 101; i++)
                count += (freq[i] * (long) Math.sqrt((double) mid / i));

            if (count >= cars) {
                answer = mid;
                end = mid - 1;
            } else start = mid + 1;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(repairCars(new int[]{4,2,3,1},10));
        System.out.println(repairCars(new int[]{5,1,8},6));
        System.out.println(repairCarsBetter(new int[]{4,2,3,1},10));
        System.out.println(repairCarsBetter(new int[]{5,1,8},6));
    }
}

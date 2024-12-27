// 1014. Best Sightseeing Pair
package Medium;

public class Medium_1014_Best_Sightseeing_Pair {
    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        // int[] arr = new int[n];
        // arr[i] -> Max value of (values[i]+i) till index i
        // arr[0] = arr[0] + 0 => arr[0]
        // arr[0] = values[0];

        // for (int i=1; i<n; i++)
        //    arr[i] = Math.max(values[i] + i, arr[i-1]);
        //

        int maxScore = 0;
        int maxTillNow = values[0];

        for (int j=1; j<n; j++) {
            maxScore = Math.max(maxScore, maxTillNow + values[j] - j);
            maxTillNow = Math.max(maxTillNow, values[j]+j);
        }
        return maxScore;
    }
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
        System.out.println(maxScoreSightseeingPair(new int[]{1,2}));
    }
}

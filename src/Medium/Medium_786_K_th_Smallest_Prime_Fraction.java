// 786. K-th Smallest Prime Fraction
package Medium;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Medium_786_K_th_Smallest_Prime_Fraction {
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (x,y) -> Double.compare((double) y[0]/y[1], (double)x[0]/x[1])
        );
        int n = arr.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                maxHeap.add(new int[] {arr[i], arr[j]});
                if (maxHeap.size() > k) maxHeap.poll();
            }
        } return maxHeap.poll();
    }
    public int[] kthSmallestPrimeFractionBetter(int[] arr, int k) {
        int n = arr.length;
        double left = 0, right = 1.0;

        // Binary search for finding the kth smallest prime fraction
        while (left < right) {
            double mid = (left + right) / 2;
            // Initialize variables to keep track of maximum fraction and indices
            double maxFraction = 0.0;
            int totalSmallerFractions = 0, numeratorIdx = 0, denominatorIdx = 0;
            int j = 1;

            // Iterate through the array to find fractions smaller than mid
            for (int i = 0; i < n-1; i++) {
                while (j < n && arr[i] >= mid * arr[j])
                    j++;
                // Count smaller fractions
                totalSmallerFractions += (n - j);
                // If we have exhausted the array, break
                if (j == n) break;

                // Calculate the fraction
                double fraction = (double) arr[i] / arr[j];
                // Update maxFraction and indices if necessary
                if (fraction > maxFraction) {
                    numeratorIdx = i;
                    denominatorIdx = j;
                    maxFraction = fraction;
                }
            }
            // Check if we have found the kth smallest prime fraction
            if (totalSmallerFractions == k) {
                return new int[]{arr[numeratorIdx], arr[denominatorIdx]};
            } else if (totalSmallerFractions > k) {
                right = mid; // Adjust the range for binary search
            } else {
                left = mid; // Adjust the range for binary search
            }
        } return new int[]{}; // Return empty array
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1,7}, 1)));
    }
}

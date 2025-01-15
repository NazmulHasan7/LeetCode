// 2657. Find the Prefix Common Array of Two Arrays
package Medium;
import java.util.Arrays;
import java.util.HashSet;

public class Medium_2657_Find_the_Prefix_Common_Array_of_Two_Arrays {
    // Brute Force Approach : TC -> O(n^3), SC -> O(1)
    public static int[] findThePrefixCommonArrayBruteForce(int[] A, int[] B) {
        int n = A.length;
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<=i; j++) {
                for (int k=0; k<=i; k++) {
                    if (A[j] == B[k]) count++;
                }
            }
            answer[i] = count;
        } return answer;
    }
    // Set Approach : TC -> O(n^2) SC -> O(2n)
    public static int[] findThePrefixCommonArraySet(int[] A, int[] B) {
        int n = A.length;
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        int[] answer = new int[n];

        for (int i=0; i<n; i++) {
            setA.add(A[i]);
            setB.add(B[i]);

            int count = 0;
            for (int j=0; j<=i; j++) {
                if (setB.contains(A[j]))
                    count++;
            }
            answer[i] = count;
        } return answer;
    }
    // GreedyCount Approach : TC -> O(n), SC -> O(n)
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        // Contains all integers from 1 to n exactly once
        int n = A.length;
        int[] freq = new int[n+1];
        int[] answer = new int[n];

        int count = 0;
        for (int i=0; i<n; i++) {
            // Since they appear only once in each array, when the frequency of a number is 2
            // it means that the number has appeared in both the array
            freq[A[i]]++;
            if (freq[A[i]] == 2) count++;
            freq[B[i]]++;
            if (freq[B[i]] == 2) count++;
            answer[i] = count;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{1,3,2,4}, new int[]{3,1,2,4})));
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{2,3,1}, new int[]{3,1,2})));
    }
}

// 1534. Count Good Triplets
package Easy;

public class Easy_1534_Count_Good_Triplets {
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;

        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k=j+1; k<n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c)
                            count++;
                    }
                }
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{3,0,1,1,9,7},7,2,3));
        System.out.println(countGoodTriplets(new int[]{1,1,2,2,3},0,0,1));
    }
}

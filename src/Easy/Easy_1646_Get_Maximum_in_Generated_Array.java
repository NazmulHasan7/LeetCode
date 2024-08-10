// 1646. Get Maximum in Generated Array
package Easy;

public class Easy_1646_Get_Maximum_in_Generated_Array {
    public static int getMaximumGenerated(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;

        for (int i=1; i<=n; i++) {
            if (2*i <= n) arr[2*i] = arr[i];
            if (2*i+1 <= n)
                arr[2*i+1] = arr[i] + arr[i+1];
            max = Math.max(max, arr[i]);
        } return max;
    }
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
        System.out.println(getMaximumGenerated(2));
        System.out.println(getMaximumGenerated(3));
    }
}

// 668. Kth Smallest Number in Multiplication Table
package Hard;

public class Hard_668_Kth_Smallest_Number_in_Multiplication_Table {
    public static int findKthNumber(int m, int n, int k) {
        int start = 1, end = m * n;
        int answer = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = getCount(m, n, mid);
            if (count < k) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        } return answer;
    }
    private static int getCount(int m, int n, int mid) {
        // int r=1, c=n;
        int count = 0;
        /* while (r<=m && c>=1) {
             if (r*c <= mid) {
                 count += c;
                 r++;
             } else c--;
        } */
        for(int i=1;i<=m;i++)
            // For example -> 12 / 2 -> position 6, but n = 3
            count += Math.min(mid / i, n);
        return count;
    }
    public static void main(String[] args) {
        System.out.println(findKthNumber(3,3,5));
        System.out.println(findKthNumber(2,3,6));
    }
}

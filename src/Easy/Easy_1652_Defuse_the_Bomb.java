// 1652. Defuse the Bomb
package Easy;
import java.util.Arrays;

public class Easy_1652_Defuse_the_Bomb {
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] answer = new int[n];
        if (k > 0) {
            for (int i=0; i<n; i++) {
                int sum = 0;
                for (int j=i+1; j<=i+k; j++)
                    sum += code[j%n];
                answer[i] = sum;
            }
        } else {
            k *= -1;
            for (int i=0; i<n; i++) {
                int sum = 0;
                for (int j=i-1; j>=i-k; j--)
                    sum += code[(j + n) % n];
                answer[i] = sum;
            }
        } return answer;
    }
    public static int[] decryptBetter(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        int sum = 0;
        int i = 0;

        if (k > 0) {
            int j = i + 1;
            while (i < n) {
                sum += code[j % n];
                if (j - i < k) j++;
                else if (j - i == k) {
                    result[i] = sum;
                    sum -= code[(j - k + 1) % n];
                    i++;
                    j++;
                }
            }
        } else if (k < 0) {
            int j = n + (i - Math.abs(k));
            while (i < n) {
                sum += code[j];
                if (j != i) j = ++j % n;
                if (j == i) {
                    result[i] = sum;
                    sum -= code[(n + (j - Math.abs(k))) % n];
                    i++;
                }
            }
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decrypt(new int[]{5,7,1,4}, 3)));
        System.out.println(Arrays.toString(decrypt(new int[]{1,2,3,4}, 0)));
        System.out.println(Arrays.toString(decrypt(new int[]{2,4,9,3}, -2)));
    }
}

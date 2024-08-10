// 1054. Distant Barcodes
package Medium;
import java.util.Arrays;

public class Medium_1054_Distant_Barcodes {
    public static int[] rearrangeBarcodes(int[] barcodes) {
        int[] freq = new int[10001];
        int maxFreqIdx = 0;

        for (int x : barcodes) {
            freq[x]++;
            if (freq[x] > freq[maxFreqIdx])
                maxFreqIdx = x;
        }

        int idx = 0;
        int[] answer = new int[barcodes.length];
        while (freq[maxFreqIdx]-- > 0) {
            answer[idx] = maxFreqIdx;
            idx += 2;
        }

        for (int i=0; i<freq.length; i++) {
            if (freq[i] == 0)  continue;
            while (freq[i]-- > 0) {
                if (idx >= barcodes.length) idx = 1;
                answer[idx] = i;
                idx += 2;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{1,1,1,2,2,2})));
        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{1,1,1,1,2,2,3,3})));
    }
}

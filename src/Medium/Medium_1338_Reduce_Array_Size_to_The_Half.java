// 1338. Reduce Array Size to The Half
package Medium;
import java.util.*;

public class Medium_1338_Reduce_Array_Size_to_The_Half {
    public static int minSetSize(int[] arr) {
        int n = arr.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr)
            map.put(x, map.getOrDefault(x,0)+1);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            maxHeap.add(new int[] {entry.getKey(), entry.getValue()});

        int setSize = 0;
        while (n > 0) {
            setSize++;
            n -= Objects.requireNonNull(maxHeap.poll())[1];
        } return setSize;
    }
    public static int minSetSizeBetter(int[] arr) {
        int max=0;
        for(int x : arr) max=Math.max(max, x);

        int[] freq = new int[max+1];
        int maxOccurrence = 0;
        for(int i:arr) freq[i]++;

        int answer = 0;
        Arrays.sort(freq);
        for(int i = freq.length-1; i >= 0; i--){
            maxOccurrence += freq[i];
            answer++;
            if(maxOccurrence >= arr.length/2)
                return answer;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(minSetSizeBetter(new int[]{3,3,3,3,5,5,5,2,2,7}));
        System.out.println(minSetSizeBetter(new int[]{7,7,7,7,7,7}));
    }
}

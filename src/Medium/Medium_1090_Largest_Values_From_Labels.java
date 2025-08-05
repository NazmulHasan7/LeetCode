// 1090. Largest Values From Labels
package Medium;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Medium_1090_Largest_Values_From_Labels {
    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        // Map -> {label, useLimit}
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int label : labels)
            map.putIfAbsent(label, useLimit);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i=0; i<values.length; i++)
            maxHeap.add(new int[]{values[i], labels[i]});

        int answer = 0;
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int value = top[0];
            int label = top[1];

            int remLimit = map.getOrDefault(label,0);
            if (remLimit == 0) continue;

            if (remLimit <= useLimit) {
                answer += value;
                remLimit--;
                if (remLimit == 0)
                    map.remove(label);
                else map.put(label, remLimit);
            }
            numWanted--;
            if (numWanted == 0) break;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(largestValsFromLabels(new int[]{5,4,3,2,1}, new int[]{1,1,2,2,3}, 3, 1));
        System.out.println(largestValsFromLabels(new int[]{5,4,3,2,1}, new int[]{1,3,3,3,2}, 3, 2));
    }
}

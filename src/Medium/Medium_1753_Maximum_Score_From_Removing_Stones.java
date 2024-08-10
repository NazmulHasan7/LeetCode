// 1753. Maximum Score From Removing Stones
package Medium;
import java.util.PriorityQueue;

public class Medium_1753_Maximum_Score_From_Removing_Stones {
    public static int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y-x);
        maxHeap.add(a);
        maxHeap.add(b);
        maxHeap.add(c);

        int points = 0;
        while (maxHeap.size() > 1) {
            points++;
            int n1 = maxHeap.poll();
            int n2 = maxHeap.poll();
            n1--;
            n2--;
            if (n1 > 0) maxHeap.add(n1);
            if (n2 > 0) maxHeap.add(n2);
        }
        return points;
    }
    public static int maximumScoreBetter(int a, int b, int c) {
        //Find maximum, minimum and middle among a, b and c
        int max = (a >= b && a >= c) ? a : (b >= a && b >= c) ? b : c;
        int min = (a <= b && a <= c) ? a : (b <= a && b <= c) ? b : c;
        int mid = (a + b + c) - (max + min);

        // If the maximum stack is bigger than both of the other stacks combined
        // Then max score can only be the combined weight of the other two stacks
        if (max >= (mid + min)) return mid + min;

        // Otherwise the max score would be the weight of the maximum stack
        // with addition to the remaining points that can be added to the answer
        return max + ((min + mid) - max) / 2;
    }
    public static void main(String[] args) {
        System.out.println(maximumScore(2,4,6));
        System.out.println(maximumScore(4,4,6));
        System.out.println(maximumScore(1,8,8));
    }
}

// 2502. Design Memory Allocator
package Medium;
import java.util.Arrays;

public class Medium_2502_Design_Memory_Allocator {
    static class Allocator {
        int[] memory;
        int N;

        public Allocator(int n) {
            N = n;
            memory = new int[n];
        }
        public int allocate(int size, int mID) {
             /* int count = 0, endIdx = 0;
             boolean spaceFound = false;

             for (int i=0; i<N; i++) {
                 if (memory[i] == 0) {
                     count++;
                     if (count == size) {
                         spaceFound = true;
                         endIdx = i;
                         break;
                     }
                 } else {
                     count = 0;
                 }
             }
             if (spaceFound) {
                 while (size-- > 0)
                     memory[endIdx--] = mID;
                 return endIdx + 1;
             }
             return -1; */

            int count = 0;
            for (int i=0; i<N; i++) {
                if (memory[i] == 0) {
                    count++;
                    if (count == size) {
                        Arrays.fill(memory, i-size+1, i+1, mID);
                        return i-size+1;
                    }
                } else {
                    count = 0;
                }
            } return -1;
        }
        public int freeMemory(int mID) {
            int freed = 0;
            for (int i=0; i<N; i++) {
                if (memory[i] == mID) {
                    memory[i] = 0;
                    freed++;
                }
            } return freed;
        }
    }
    public static void main(String[] args) {
        Allocator loc = new Allocator(10);
        loc.allocate(1, 1);
        loc.allocate(1, 2);
        loc.allocate(1, 3);
        loc.freeMemory(2);
        loc.allocate(3, 4);
        loc.allocate(1, 1);
        loc.allocate(1, 1);
        loc.freeMemory(1);
        loc.allocate(10, 2);
        loc.freeMemory(7);
    }
}

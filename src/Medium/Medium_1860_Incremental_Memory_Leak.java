// 1860. Incremental Memory Leak
package Medium;
import java.util.Arrays;

public class Medium_1860_Incremental_Memory_Leak {
    public static int[] memLeak(int memory1, int memory2) {
        int time = 1;
        while (true) {
            if (memory1 >= time && memory1 >= memory2)
                memory1 -= time;
            else if (memory2 >= time)
                memory2 -= time;
            else
                return new int[] {time, memory1, memory2};
            time++;
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(memLeak(2,2)));
        System.out.println(Arrays.toString(memLeak(8,11)));
    }
}

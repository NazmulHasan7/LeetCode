// 2211. Count Collisions on a Road
package Medium;

public class Medium_2211_Count_Collisions_on_a_Road {
    public static int countCollisions(String directions) {
        int count = 0, length = directions.length();
        char prevDir = directions.charAt(0);
        int carsInQueue = 0;

        for (int i=1; i<length; i++) {
            char currDir = directions.charAt(i);
            // R --> <-- L => Collides [2]
            if (prevDir == 'R' && currDir == 'L') {
                prevDir = 'S'; // Collides and becomes stationary
                count += 2 + carsInQueue;
                carsInQueue = 0;
            } // S <-- L => Collides [1]
            else if (prevDir == 'S' && currDir == 'L') {
                count += 1 + carsInQueue;
            } // R --> S => Collides [1]
            else if (prevDir == 'R' && currDir == 'S') {
                count += 1 + carsInQueue;
                prevDir = 'S';
                carsInQueue = 0;
            } // No collision => update previous direction
            else {
                // Cars with same direction creates a queue
                if (prevDir == 'R' && currDir == 'R')
                    carsInQueue++;
                prevDir = currDir;
            }
        } return count;
    }
    public int countCollisionsBetter(String str) {
        int n = str.length();
        int ans = 0;
        int start=0, end=n-1;
        // Cars moving <-- L direction before R or S never collides
        while (start < n && str.charAt(start) == 'L') start++;
        // Cars moving R --> direction after L or S never collides
        while (end >= 0 && str.charAt(end) == 'R') end--;

        // These are the cars that collide with each other
        for (int i=start; i<=end; i++){
            // S has no impact for example R[1]R[1]RS[1] --> RRR
            if (str.charAt(i) != 'S') ans++;
        } return ans;
    }
    public static void main(String[] args) {
        System.out.println(countCollisions("RLRSLL"));
        System.out.println(countCollisions("LLRR"));
    }
}

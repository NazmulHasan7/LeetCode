// 3273. Minimum Amount of Damage Dealt to Bob
package Hard;
import java.util.PriorityQueue;

public class Hard_3273_Minimum_Amount_of_Damage_Dealt_to_Bob {
    // Approach -> Eliminate the enemy with greater damage ratio first
    static class Enemy {
        int damage;
        int health;
        double ratio;
        int hits;
        Enemy(int damage, int health, int hits, double ratio) {
            this.damage = damage;
            this.health = health;
            this.hits = hits;
            this.ratio = ratio;
        }
    }
    public static long minDamage(int power, int[] damage, int[] health) {
        long totalDamagePerSecond = 0;
        int n = health.length;
        PriorityQueue<Enemy> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.ratio, a.ratio));

        for (int i=0; i<n; i++) {
            totalDamagePerSecond += damage[i];
            // hits required to eliminate the enemy
            int hitsRequired = (int) (Math.ceil((1.0 * health[i]) / power));
            // damage ratio of the enemy
            double ratio = (1.0 * damage[i]) / hitsRequired;
            maxHeap.add(new Enemy(damage[i], health[i], hitsRequired, ratio));
        }
        long answer = 0;
        while (!maxHeap.isEmpty()) {
            Enemy e = maxHeap.poll();
            answer += (totalDamagePerSecond * e.hits);
            totalDamagePerSecond -= e.damage;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(minDamage(4, new int[]{1,2,3,4}, new int[]{4,5,6,8}));
        System.out.println(minDamage(1, new int[]{1,1,1,1}, new int[]{1,2,3,4}));
        System.out.println(minDamage(8, new int[]{40}, new int[]{59}));
    }
}

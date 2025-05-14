// 3207. Maximum Points After Enemy Battles
package Medium;

public class Medium_3207_Maximum_Points_After_Enemy_Battles {
    public static long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        /*
        Imagine playing a game which has some monsters. Given a starting HP, you could choose to:
        Battle a monster and gain one kill if your HP is larger (your HP is depleted by the monster's HP),
            but it will respawn right away.
        If you have at least killed one, you could steal life of the monster, but he will not respawn after this.*/

        long points = 0L;
        int minEnergy = Integer.MAX_VALUE;
        long totalEnergy = currentEnergy;

        // assuming an enemy is killed
        for (int energy : enemyEnergies) {
            totalEnergy += energy;
            minEnergy = Math.min(minEnergy, energy);
        }
        if (currentEnergy < minEnergy) return 0;

        // do not kill the enemy with the least energy
        // instead we will kill it again and again to earn points
        totalEnergy -= minEnergy; // since not killed cannot consume his energy


        // now, kill the enemy with the least energy first time to earn one point
        totalEnergy -= minEnergy;
        points++;

        points += totalEnergy / minEnergy;
        return points;
    }
    public static void main(String[] args) {
        System.out.println(maximumPoints(new int[]{3,2,2},2));
        System.out.println(maximumPoints(new int[]{2},10));
    }
}

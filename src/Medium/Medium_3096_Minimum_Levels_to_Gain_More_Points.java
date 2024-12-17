// 3096. Minimum Levels to Gain More Points
package Medium;

public class Medium_3096_Minimum_Levels_to_Gain_More_Points {
    public static int minimumLevels(int[] possible) {
        int n = possible.length;
        int totalScore = 0;

        for (int i=0; i<n; i++) {
            if (possible[i] == 0)
                possible[i] = -1;
            totalScore += possible[i];
        }

        int aliceScore = 0;
        // Need to keep at least one level for Bob
        for (int i=0; i<n-1; i++) {
            aliceScore += possible[i];
            int bobScore = totalScore - aliceScore;
            if (aliceScore > bobScore) return i+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(minimumLevels(new int[]{1,0,1,0}));
        System.out.println(minimumLevels(new int[]{1,1,1,1,1}));
        System.out.println(minimumLevels(new int[]{0,0}));
    }
}

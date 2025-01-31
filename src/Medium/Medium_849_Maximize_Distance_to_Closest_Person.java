// 849. Maximize Distance to Closest Person
package Medium;

public class Medium_849_Maximize_Distance_to_Closest_Person {
    public static int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int prevPerson = -1;
        int maxDistance = 0;

        for (int i=0; i<n; i++) {
            if (seats[i] == 1) {
                if (prevPerson == -1)
                    // Max distance could be the distance of first seat and first person
                    maxDistance = i;
                else
                    maxDistance = Math.max(maxDistance, (i-prevPerson)/2);
                prevPerson = i;
            }
        }
        // Check for last person and last seat
        maxDistance = Math.max(maxDistance, n-1-prevPerson);
        return maxDistance;
    }
    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,0}));
        System.out.println(maxDistToClosest(new int[]{0,1}));
    }
}

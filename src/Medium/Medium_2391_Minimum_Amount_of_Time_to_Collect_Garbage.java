// 2391. Minimum Amount of Time to Collect Garbage
package Medium;

public class Medium_2391_Minimum_Amount_of_Time_to_Collect_Garbage {
    public static int garbageCollection(String[] garbage, int[] travel) {
        int time = 0;
        // Time taken just to collect the all garbage
        for (String g : garbage) time += g.length();

        // Finding the last occurrences of each garbage types
        int lastG = -1, lastP = -1, lastM = -1;
        for (int i=garbage.length-1; i>=0; i--) {
            if (lastG == -1 && garbage[i].contains("G")) lastG = i;
            if (lastP == -1 && garbage[i].contains("P")) lastP = i;
            if (lastM == -1 && garbage[i].contains("M")) lastM = i;
        }
        // Calculate the travel time
        int index = 0;
        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = false;
            if (index < lastG) {
                time += travel[index];
                keepGoing = true;
            }
            if (index < lastM) {
                time += travel[index];
                keepGoing = true;
            }
            if (index < lastP) {
                time += travel[index];
                keepGoing = true;
            }
            index++;
        } return time;
    }
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[] {"G","P","GP","GG"}, new int[] {2,4,3}));
        System.out.println(garbageCollection(new String[] {"MMM","PGM","GP"}, new int[] {3,10}));
    }
}

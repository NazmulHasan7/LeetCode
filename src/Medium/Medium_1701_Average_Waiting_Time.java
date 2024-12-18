// 1701. Average Waiting Time
package Medium;

public class Medium_1701_Average_Waiting_Time {
    public static double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int chefAvailableAt = customers[0][0];

        long waitingTime = 0;
        for (int i=0; i<n; i++) {
            int arrivalTime = customers[i][0];
            int cookingTime = customers[i][1];
            int timeTaken = chefAvailableAt + cookingTime;
            waitingTime += (timeTaken - arrivalTime);
            chefAvailableAt = timeTaken;

            if (i+1 < n) {
                int nextArrivalTime = customers[i+1][0];
                if (timeTaken < nextArrivalTime)
                    chefAvailableAt = nextArrivalTime;
            }
        }
        return (double) waitingTime / n;
    }
    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
        System.out.println(averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }
}

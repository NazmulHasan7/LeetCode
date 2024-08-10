// 2073. Time Needed to Buy Tickets
package Easy;

public class Easy_2073_Time_Needed_to_Buy_Tickets {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        //  Those who have no more tickets to buy will leave the line
        int time = 0;
        while (tickets[k] != 0) {
            for (int i=0; i<tickets.length && tickets[k]!=0; i++) {
                if (tickets[i] == 0) continue;
                else {
                    time++;
                    tickets[i]--;
                }
            }
        } return time;
    }
    public static int timeRequiredToBuyBetter(int[] tickets, int k) {
        //  Those who have no more tickets to buy will leave the line
        int time = 0;
        for (int i=0; i<tickets.length; i++) {
            // Can buy up to k tickets
            if (i<=k) time += Math.min(tickets[i], tickets[k]);
                // Can buy at most k-1 tickets
            else time += Math.min(tickets[i], tickets[k]-1);
        } return time;
    }
    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[] {2,3,2}, 2));
        System.out.println(timeRequiredToBuy(new int[] {5,1,1,1}, 0));
    }
}

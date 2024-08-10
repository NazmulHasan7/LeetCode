// 2409. Count Days Spent Together
package Easy;

public class Easy_2409_Count_Days_Spent_Together {
    public static int getDays(int month) {
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        for (int i=0; i<month-1; i++) totalDays += days[i];
        return totalDays;
    }
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceStartMonth = (arriveAlice.charAt(0)-'0')*10 + arriveAlice.charAt(1)-'0';
        int aliceEndMonth   = (leaveAlice.charAt(0)-'0')*10 + leaveAlice.charAt(1)-'0';
        int aliceStartDay   = (arriveAlice.charAt(3)-'0')*10 + arriveAlice.charAt(4)-'0';
        int aliceEndDay     = (leaveAlice.charAt(3)-'0')*10 + leaveAlice.charAt(4)-'0';
        int aliceStartsAt   = getDays(aliceStartMonth) + aliceStartDay;
        int aliceEndsAt     = getDays(aliceEndMonth) + aliceEndDay;
        // System.out.println(aliceStartsAt + " " + aliceEndsAt);

        int bobStartMonth   = (arriveBob.charAt(0)-'0')*10 + arriveBob.charAt(1)-'0';
        int bobEndMonth     = (leaveBob.charAt(0)-'0')*10 + leaveBob.charAt(1)-'0';
        int bobStartDay     = (arriveBob.charAt(3)-'0')*10 + arriveBob.charAt(4)-'0';
        int bobEndDay       = (leaveBob.charAt(3)-'0')*10 + leaveBob.charAt(4)-'0';
        int bobStartsAt   = getDays(bobStartMonth) + bobStartDay;
        int bobEndsAt     = getDays(bobEndMonth) + bobEndDay;
        // System.out.println(bobStartsAt + " " + bobEndsAt);

        if (aliceEndsAt < bobStartsAt || bobEndsAt < aliceStartsAt) return 0;
        return Math.min(aliceEndsAt, bobEndsAt) - Math.max(aliceStartsAt, bobStartsAt) + 1;
    }
    public static void main(String[] args) {
        System.out.println(countDaysTogether("08-15", "08-18", "08-16", "08-19"));
        System.out.println(countDaysTogether("10-01", "10-31", "11-01", "12-31"));
    }
}

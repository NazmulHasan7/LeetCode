// 1450. Number of Students Doing Homework at a Given Time
package Easy;

public class Easy_1450_Number_of_Students_Doing_Homework_at_a_Given_Time {
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i=0; i<startTime.length; i++)
            if (startTime[i] <= queryTime && endTime[i] >= queryTime)
                count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(busyStudent(new int[] {1,2,3}, new int[] {3,2,7}, 4));
        System.out.println(busyStudent(new int[] {4}, new int[] {4}, 4));
    }
}

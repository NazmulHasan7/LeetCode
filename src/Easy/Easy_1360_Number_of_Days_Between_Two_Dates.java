// 1360. Number of Days Between Two Dates
package Easy;

public class Easy_1360_Number_of_Days_Between_Two_Dates {
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0));
    }
    public static int getMonthDays (int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 30;
        };
    }
    public static int countDays(String date) {
        int year  = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int days  = Integer.parseInt(date.substring(8, 10));
        int[] monthDays = { 31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        for (int y=1971; y<year; y++)
            days += isLeapYear(y) ? 366 : 365;
        for (int m=1; m<month; m++)
            days += monthDays[m-1];
        return days;
    }
    public static int daysBetweenDates(String date1, String date2) {
        return Math.abs(countDays(date1) - countDays(date2));
    }
    public static void main(String[] args) {
        System.out.println(daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(daysBetweenDates("2020-01-15", "2019-12-31"));
    }
}

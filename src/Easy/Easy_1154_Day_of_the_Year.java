// 1154. Day of the Year
package Easy;

public class Easy_1154_Day_of_the_Year {
    public static boolean isLepaYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static int getDays(int month) {
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        for (int i=0; i<month-1; i++)
            totalDays += days[i];
        return totalDays;
    }
    public static int dayOfYear(String date) {
        int year  = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int days  = Integer.parseInt(date.substring(8, 10));
        int totalDays = getDays(month) + days;
        return (isLepaYear(year) && month > 2) ? ++totalDays : totalDays;
    }
    public int dayOfYearBetter(String date) {
        int year  = (date.charAt(0)-'0')*1000 + (date.charAt(1)-'0')*100 +
                (date.charAt(2)-'0')*10 + (date.charAt(3)-'0');
        int month = (date.charAt(5) - '0') * 10 + (date.charAt(6) - '0');
        int days  = (date.charAt(8) - '0') * 10 + (date.charAt(9) - '0');
        int total = 0;
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i=0; i<month-1; i++)
            total += daysInMonth[i];
        total+= days;
        return (isLepaYear(year) && month > 2) ? ++total : total;
    }
    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-02-10"));
        System.out.println(dayOfYear("2019-01-09"));
    }
}

// 1507. Reformat Date
package Easy;

public class Easy_1507_Reformat_Date {
    public static String getMonth(String month) {
        return switch (month) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> null;
        };
    }
    public static String reformatDate(String date) {
        int length = date.length();
        StringBuilder sb = new StringBuilder();
        sb.append(date, length-4, length);
        sb.append("-");
        sb.append(getMonth(date.substring(length-8, length-5)));
        sb.append("-");
        if (date.charAt(1) >= '0' && date.charAt(1) <= '9') {
            sb.append(date, 0, 2);
        } else sb.append("0").append(date.charAt(0));
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(reformatDate("26th May 1960"));
        System.out.println(reformatDate("6th Jun 1933"));
        System.out.println(reformatDate("20th Oct 2052"));
    }
}

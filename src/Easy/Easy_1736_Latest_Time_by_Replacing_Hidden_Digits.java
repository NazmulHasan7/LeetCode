// 1736. Latest Time by Replacing Hidden Digits
package Easy;

public class Easy_1736_Latest_Time_by_Replacing_Hidden_Digits {
    public static String maximumTime(String time) {
        char[] timeArr = time.toCharArray();
        if (timeArr[0] == '?') {
            if (timeArr[1] == '?') timeArr[0] = '2';
            else timeArr[0] = timeArr[1] > '3' ? '1' : '2';
        }
        if (timeArr[1] == '?') timeArr[1] = timeArr[0] == '2' ? '3' : '9';
        if (timeArr[3] == '?') timeArr[3] = '5';
        if (timeArr[4] == '?') timeArr[4] = '9';
        return new String(timeArr);
    }
    public static void main(String[] args) {
        System.out.println(maximumTime("2?:?0"));
        System.out.println(maximumTime("0?:3?"));
        System.out.println(maximumTime("1?:22"));
        System.out.println(maximumTime("?4:03"));
    }
}

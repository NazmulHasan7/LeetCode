// 2437. Number of Valid Clock Times
package Easy;

public class Easy_2437_Number_of_Valid_Clock_Times {
    public static int countTime(String time) {
        int answer = 1;
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') answer *= 24;
            else answer *= time.charAt(1) <= '3' ? 3 : 2;
        } else if (time.charAt(1) == '?')
            answer *= time.charAt(0) < '2' ? 10 : 4;
        if (time.charAt(3) == '?') answer *= 6;
        if (time.charAt(4) == '?') answer *= 10;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(countTime("?5:00"));
        System.out.println(countTime("0?:0?"));
        System.out.println(countTime("??:??"));
    }
}

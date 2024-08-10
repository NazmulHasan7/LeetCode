// 2678. Number of Senior Citizens
package Easy;

public class Easy_2678_Number_of_Senior_Citizens {
    public static int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details)
            if (Integer.parseInt(detail.substring(11, 13)) > 60)
                count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSeniors(new String[] {"7868190130M7522","5303914400F9211","9273338290F4010"}));
        System.out.println(countSeniors(new String[] {"1313579440F2036","2921522980M5644"}));
    }
}

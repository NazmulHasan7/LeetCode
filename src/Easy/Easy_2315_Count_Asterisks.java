// 2315. Count Asterisks
package Easy;

public class Easy_2315_Count_Asterisks {
    public static int countAsterisks(String s) {
        int bar = -1, count = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') bar++;
            else if (c == '*')
                if (bar % 2 != 0)
                    count++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println(countAsterisks("iamprogrammer"));
        System.out.println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
        System.out.println(countAsterisks("*||*|||||*|*|***||*||***|"));
        System.out.println(countAsterisks("***"));
    }
}

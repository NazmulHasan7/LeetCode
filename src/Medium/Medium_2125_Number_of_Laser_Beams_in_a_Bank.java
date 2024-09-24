// 2125. Number of Laser Beams in a Bank
package Medium;

public class Medium_2125_Number_of_Laser_Beams_in_a_Bank {
    public static int numberOfBeams(String[] bank) {
        int answer = 0;
        int prevRowCount = 0;

        for (String row : bank) {
            int currentRowCount = 0;
            for (char c : row.toCharArray())
                if (c == '1') currentRowCount++;

            if (currentRowCount > 0) {
                answer += (prevRowCount * currentRowCount);
                prevRowCount = currentRowCount;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[]{"011001","000000","010100","001000"}));
        System.out.println(numberOfBeams(new String[]{"000","111","000"}));
    }
}

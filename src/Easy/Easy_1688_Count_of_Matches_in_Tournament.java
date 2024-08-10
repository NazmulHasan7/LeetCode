// 1688. Count of Matches in Tournament
package Easy;

public class Easy_1688_Count_of_Matches_in_Tournament {
    public static int numberOfMatches(int n) {
        int matches = 0;
        while (n != 1) {
            if (n % 2 == 0)
                matches += n /= 2;
            else {
                n = (n - 1) / 2;
                matches += n++;
            }
        } return matches;
    }
    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));
        System.out.println(numberOfMatches(14));
    }
}

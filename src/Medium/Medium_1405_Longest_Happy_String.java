// 1405. Longest Happy String
package Medium;

public class Medium_1405_Longest_Happy_String {
    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int n = a + b + c;
        int countA = 0, countB = 0, countC = 0;

        while (n-- > 0) {
            if ((a>=b && a>=c && countA<2) || (countB == 2 && a>0) || (countC == 2 && a>0)) {
                sb.append('a');
                a--;
                countA++;
                countB = countC = 0;
            } else if ((b>=a && b>=c && countB<2) || (countA == 2 && b>0) || (countC == 2 && b>0)) {
                sb.append('b');
                b--;
                countB++;
                countA = countC = 0;
            } else if ((c>=a && c>=b && countC<2) || (countA == 2 && c>0) || (countB == 2 && c>0)) {
                sb.append('c');
                c--;
                countC++;
                countA = countB = 0;
            }
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(longestDiverseString(1,1,7));
        System.out.println(longestDiverseString(7,1,0));
    }
}

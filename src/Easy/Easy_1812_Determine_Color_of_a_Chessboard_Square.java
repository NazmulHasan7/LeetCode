// 1812. Determine Color of a Chessboard Square
package Easy;

public class Easy_1812_Determine_Color_of_a_Chessboard_Square {
    public static boolean squareIsWhite(String coordinates) {
        // Black Odd -> a1, c1, a3, c3, a5, c5 -> Char Odd, Number - odd
        // Black Even -> a2, c2, a4, c4, a6, c6 -> Char Even, Number - Even
        int letter = coordinates.charAt(0)-'a'+1;
        int number = coordinates.charAt(1)-'0';
        if (letter % 2 == 0 && number % 2 == 0) return false;
        else if (letter % 2 != 0 && number % 2 != 0) return false;
        else return true;
    }
    public static void main(String[] args) {
        System.out.println(squareIsWhite("a1"));
        System.out.println(squareIsWhite("h3"));
        System.out.println(squareIsWhite("c7"));
    }
}

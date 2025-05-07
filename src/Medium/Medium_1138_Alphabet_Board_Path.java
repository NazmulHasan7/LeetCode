// 1138. Alphabet Board Path
package Medium;

public class Medium_1138_Alphabet_Board_Path {
    public static String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int currR = 0, currC = 0;

        for (char c : target.toCharArray()) {
            int x = c - 'a';
            int tarR = x / 5;
            int tarC = x % 5;

            if (c == 'z') {
                // Move horizontal first, then vertical
                if (tarC < currC) sb.append("L".repeat(currC - tarC));
                if (tarR > currR) sb.append("D".repeat(tarR - currR));
            } else {
                // Normal: move vertical first, then horizontal
                if (tarR < currR) sb.append("U".repeat(currR - tarR));
                if (tarC < currC) sb.append("L".repeat(currC - tarC));
                if (tarR > currR) sb.append("D".repeat(tarR - currR));
                if (tarC > currC) sb.append("R".repeat(tarC - currC));
            }
            sb.append("!");
            currR = tarR;
            currC = tarC;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(alphabetBoardPath("leet"));
        System.out.println(alphabetBoardPath("code"));
    }
}

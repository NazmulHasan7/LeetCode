// 2337. Move Pieces to Obtain a String
package Medium;

public class Medium_2337_Move_Pieces_to_Obtain_a_String {
    public static boolean canChange(String start, String target) {
        int n = start.length();
        // Condition: after removing all blanks target should be equal to start
        int i=0, j=0;
        while (i<n && j<n) {
            char startChar = start.charAt(i);
            char targetChar = target.charAt(j);
            // Skipping all the blanks in start and target
            if (startChar == '_') {
                i++;
                continue;
            } else if (targetChar == '_') {
                j++;
                continue;
            }
            // After skipping the blanks check the characters
            if (startChar != targetChar) return false;
            // Consider the edge case --> start L_ target _L which is not possible
            if (startChar == 'L' && i<j) return false;
            // Consider the edge case --> start _R target R_ which is not possible
            if (targetChar == 'R' && i>j) return false;
            i++; j++;
        }
        while (i<n)
            if (start.charAt(i++) != '_') return false;
        while (j<n)
            if(target.charAt(j++) != '_') return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canChange("_L__R__R_", "L______RR"));
        System.out.println(canChange("R_L_", "__LR"));
        System.out.println(canChange("_R", "R_"));
    }
}

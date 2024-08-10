// 777. Swap Adjacent in LR String
package Medium;

public class Medium_777_Swap_Adjacent_in_LR_String {
    // Same Concept of 2337. Move Pieces to Obtain a String
    public static boolean canTransform(String start, String end) {
        int n = start.length();
        int i=0, j=0;

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;
            if (i==n || j==n) return i==n && j==n;

            char sc = start.charAt(i);
            char ec = end.charAt(j);
            if (sc != ec) return false;
            // XL --> LX but L can be shifted to Left only
            // Consider the edge case --> start LX target XL which is not possible
            if (ec == 'L' && i<j) return false;
                // RX --> XR but R can be shifted to Right only
                // Consider the edge case --> start XR target RX which is not possible
            else if (ec == 'R' && i>j) return false;

            i++; j++;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(canTransform("X", "L"));
    }
}

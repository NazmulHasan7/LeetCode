// 2103. Rings and Rods
package Easy;

public class Easy_2103_Rings_and_Rods {
    public static int countPoints(String rings) {
        boolean[][] colors = new boolean[10][3];
        char color, ring;
        for (int i=1; i<rings.length(); i+=2) {
            ring = rings.charAt(i);
            color = rings.charAt(i-1);
            if (color == 'R')
                colors[ring-'0'][0] = true;
            else if (color == 'G')
                colors[ring-'0'][1] = true;
            else colors[ring-'0'][2] = true;
        }
        int count = 0;
        for (boolean[] booleans : colors)
            if (booleans[0] && booleans[1] && booleans[2])
                count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPoints("B0R0G0R9R0B0G0"));
        System.out.println(countPoints("G4"));
    }
}

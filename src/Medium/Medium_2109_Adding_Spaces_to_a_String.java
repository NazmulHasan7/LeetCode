// 2109. Adding Spaces to a String
package Medium;

public class Medium_2109_Adding_Spaces_to_a_String {
    public static String addSpaces(String s, int[] spaces) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (index < spaces.length && i == spaces[index]) {
                sb.append(" ");
                index++;
                i--;
            } else sb.append(s.charAt(i));
        } return sb.toString();
    }
    public static String addSpacesBetter(String s, int[] spaces) {
        int index = 0, k = 0;
        char[] crr = new char[s.length() + spaces.length];
        for (int i=0; i<s.length(); i++) {
            if (index < spaces.length && i == spaces[index]) {
                crr[k++] = ' ';
                index++;
            } crr[k++] = s.charAt(i);
        } return new String(crr);
    }
    public static void main(String[] args) {
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[] {8,13,15}));
        System.out.println(addSpaces("icodeinpython", new int[] {1,5,7,9}));
        System.out.println(addSpaces("spacing", new int[] {0,1,2,3,4,5,6}));
        System.out.println(addSpacesBetter("LeetcodeHelpsMeLearn", new int[] {8,13,15}));
        System.out.println(addSpacesBetter("icodeinpython", new int[] {1,5,7,9}));
        System.out.println(addSpacesBetter("spacing", new int[] {0,1,2,3,4,5,6}));
    }
}

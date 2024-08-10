// 2810. Faulty Keyboard
package Easy;

public class Easy_2810_Faulty_Keyboard {
    public static String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i=0; i<s.length(); i++) {
            c = s.charAt(i);
            if (c == 'i') sb.reverse();
            else sb.append(c);
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(finalString("string"));
        System.out.println(finalString("poiinter"));
    }
}

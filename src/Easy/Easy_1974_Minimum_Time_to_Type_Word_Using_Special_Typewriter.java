// 1974. Minimum Time to Type Word Using Special Typewriter
package Easy;

public class Easy_1974_Minimum_Time_to_Type_Word_Using_Special_Typewriter {
    public static int minTimeToType(String word) {
        int time = 0, value;
        char pointer = 'a';
        int length = word.length();
        for (char c : word.toCharArray()) {
            value = Math.min(Math.abs(pointer-c), 26-Math.abs(pointer-c));
            time += value;
            pointer = c;
        } return time + length;
    }
    public static void main(String[] args) {
        System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("bza"));
        System.out.println(minTimeToType("zjpc"));
    }
}

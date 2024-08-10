// 1805. Number of Different Integers in a String
package Easy;
import java.util.HashSet;

public class Easy_1805_Number_of_Different_Integers_in_a_String {
    public static int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean zero = false;

        for (char c : word.toCharArray()) {
            if (c>='0' && c<='9') {
                if (!(sb.isEmpty() && c=='0')) sb.append(c);
                    // If the number is 0
                else if (sb.isEmpty()) zero = true;
            } else {
                if (!sb.isEmpty()) {
                    set.add(sb.toString());
                    sb.setLength(0);
                } else if (zero)
                    set.add("0");
                zero = false;
            }
        } if (!sb.isEmpty()) set.add(sb.toString());
        else if (zero) set.add("0");
        // System.out.println(set);
        return set.size();
    }
    public static int numDifferentIntegersBetter(String word) {
        int length = word.length();
        char[] crr = word.toCharArray();
        int startIndex, endIndex;
        HashSet<String> set = new HashSet<>();

        for (int i=0; i<length; i++) {
            if (Character.isDigit(crr[i])) {
                while (i<length && crr[i] == '0') i++;
                startIndex = endIndex = i;
                while (endIndex<length && Character.isDigit(crr[endIndex]))
                    endIndex++;
                set.add(word.substring(startIndex, endIndex));
                i = endIndex;
            }
        } // System.out.println(set);
        return set.size();
    }
    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("a1b01c001"));
        System.out.println(numDifferentIntegers("a1b01c000"));
        System.out.println(numDifferentIntegers("ubhb4xkon7yxlr0007c"));

        System.out.println(numDifferentIntegersBetter("a123bc34d8ef34"));
        System.out.println(numDifferentIntegersBetter("leet1234code234"));
        System.out.println(numDifferentIntegersBetter("a1b01c001"));
        System.out.println(numDifferentIntegersBetter("a1b01c000"));
        System.out.println(numDifferentIntegersBetter("ubhb4xkon7yxlr0007c"));
    }
}

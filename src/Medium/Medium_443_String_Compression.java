// 443. String Compression
package Medium;

public class Medium_443_String_Compression {
    public static int compress(char[] chars) {
        int index = 0, size = chars.length;
        int entryIndex = 0;
        int startIndex, difference;

        while (index < size) {
            startIndex = index;
            chars[entryIndex++] = chars[startIndex];
            while (index+1 < size && chars[index] == chars[index+1])
                index++;

            difference = index - startIndex;
            if (difference > 0) {
                difference++;
                if (difference > 9) {
                    char[] digits = String.valueOf(difference).toCharArray();
                    for (char c : digits) chars[entryIndex++] = c;
                } else {
                    chars[entryIndex++] = (char)('0'+(difference));
                }
            } index++;
        } return entryIndex;
    }
    public static void main(String[] args) {
        System.out.println(compress(new char[] {'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[] {'a','b','c','d'}));
        System.out.println(compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(compress(new char[]{'a','a','a','b','b','a','a'}));
    }
}

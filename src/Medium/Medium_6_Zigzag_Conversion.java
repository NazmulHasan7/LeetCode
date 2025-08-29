// 6. Zigzag Conversion
package Medium;

public class Medium_6_Zigzag_Conversion {
    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++)
            rows[i] = new StringBuilder();

        int r = 0;
        boolean goDown = true;
        for (char c : s.toCharArray()) {
            rows[r].append(c);
            if (r == 0) goDown = true;
            else if (r == numRows-1)
                goDown = false;

            if (goDown) r++;
            else r--;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder str : rows)
            answer.append(str);
        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("PAYPALISHIRING",4));
        System.out.println(convert("A",1));
    }
}

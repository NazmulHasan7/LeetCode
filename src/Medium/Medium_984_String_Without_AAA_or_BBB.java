// 984. String Without AAA or BBB
package Medium;

public class Medium_984_String_Without_AAA_or_BBB {
    public static String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();

        int aCount = 0, bCount = 0;
        while (a > 0 || b > 0) {
            if (a > b && aCount < 2 || bCount == 2) {
                sb.append('a');
                a--;
                aCount++;
                bCount = 0;
            } else {
                sb.append('b');
                b--;
                bCount++;
                aCount = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(strWithout3a3b(1, 2));
        System.out.println(strWithout3a3b(4, 1));
    }
}

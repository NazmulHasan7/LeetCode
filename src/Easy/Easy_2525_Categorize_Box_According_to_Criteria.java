// 2525. Categorize Box According to Criteria
package Easy;

public class Easy_2525_Categorize_Box_According_to_Criteria {
    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false, heavy = false;
        if (mass >= 100) heavy = true;
        long volume = (long) length * width * height;
        if (volume >= 1000_000_000 || length >= 10000 || height >= 10000 || width >= 10000 || mass >= 10000)
            bulky = true;

        if (bulky) {
            if (heavy) return "Both";
            return "Bulky";
        } else if (heavy) return "Heavy";
        return "Neither";
    }
    public static void main(String[] args) {
        System.out.println(categorizeBox(1000, 35, 700, 300));
        System.out.println(categorizeBox(200, 50, 800, 50));
        System.out.println(categorizeBox(1002, 1808, 68, 676));
    }
}

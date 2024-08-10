// 1945. Sum of Digits of String After Convert
package Easy;

public class Easy_1945_Sum_of_Digits_of_String_After_Convert {
    public static int getLucky(String s, int k) {
        StringBuilder number = new StringBuilder();
        for (char c : s.toCharArray())
            number.append(c-'a'+1);

        int sumOfDigits = 0;
        String tempNumber = number.toString();
        while (k-- > 0) {
            sumOfDigits = 0;
            for (char c : tempNumber.toCharArray())
                sumOfDigits += c-'0';
            if (sumOfDigits < 10) break;
            tempNumber = String.valueOf(sumOfDigits);
        } return sumOfDigits;
    }
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        } return sum;
    }
    public static int getLuckyBetter(String s, int k) {
        int sum = 0;
        for (char c : s.toCharArray())
            sum += sumOfDigits(c-'a'+1);
        while(--k > 0)
            sum = sumOfDigits(sum);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(getLuckyBetter("iiii", 1));
        System.out.println(getLuckyBetter("leetcode", 2));
        System.out.println(getLuckyBetter("zbax", 2));
        System.out.println(getLuckyBetter("dbvmfhnttvr", 5));
        System.out.println(getLucky("iiii", 1));
        System.out.println(getLucky("leetcode", 2));
        System.out.println(getLucky("zbax", 2));
        System.out.println(getLucky("dbvmfhnttvr", 5));
    }
}

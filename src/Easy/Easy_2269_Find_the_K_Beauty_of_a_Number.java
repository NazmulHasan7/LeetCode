// 2269. Find the K-Beauty of a Number
package Easy;

public class Easy_2269_Find_the_K_Beauty_of_a_Number {
    public static int divisorSubstrings(int num, int k) {
        int count = 0;
        String number = String.valueOf(num);
        int length = number.length();
        String subNumber;
        int subNum;

        for (int i=0; i<length-k+1; i++) {
            subNumber = number.substring(i, i+k);
            subNum = Integer.parseInt(subNumber);
            if (subNum != 0 && num % subNum == 0)
                count++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240, 2));
        System.out.println(divisorSubstrings(430043, 2));
    }
}

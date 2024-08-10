// 771. Jewels and Stones
package Easy;

public class Easy_771_Jewels_and_Stones {
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char sc : stones.toCharArray())
            for (char jc : jewels.toCharArray())
                if (jc == sc) count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA","aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }
}

//461. Hamming Distance
package Easy;

public class Easy_461_Hamming_Distance {
    public static int hammingDistance(int x, int y) {
        int distance = 0;
        while (x != 0 || y != 0) {
            if ((x&1) != (y&1)) distance++;
            x >>= 1;
            y >>= 1;
        } return distance;
    }
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(3, 1));
    }
}

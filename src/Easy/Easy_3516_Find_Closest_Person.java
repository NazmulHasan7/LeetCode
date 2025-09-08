// 3516. Find Closest Person
package Easy;

public class Easy_3516_Find_Closest_Person {
    public static int findClosest(int x, int y, int z) {
        int xz = Math.abs(x-z);
        int yz = Math.abs(y-z);
        if (xz < yz) return 1;
        else return (yz < xz) ? 2 : 0;
    }
    public static void main(String[] args) {
        System.out.println(findClosest(2,7,4));
        System.out.println(findClosest(2,5,6));
        System.out.println(findClosest(1,5,3));
    }
}

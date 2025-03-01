// 1551. Minimum Operations to Make Array Equal
package Medium;

public class Medium_1551_Minimum_Operations_to_Make_Array_Equal {
    /*  arr[i] = 2*i + 1
        For even n -> 1 3 5 7 9 11 -> mid/target = (11 + 1) / 2 = 6 == (n/2 * 2) + 1
        Iterate the half (inc first half, dec second half) off the array -> operations count -> 5, 3, 1 => 9

        For odd n -> 1 3 5 7 9 11 13 -> mid/target = (13 + 1) / 2 = 7 == (n/2 * 2) + 1
        Iterate the half (inc first half, dec second half) off the array -> operations count -> 6, 4, 2 => 12

        Key -> Target here is actually n
        */
    public static int minOperations(int n) {
        int ops = 0;
        for (int i=1; i<n; i+=2)
            ops += (n - i);
        return ops;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(3));
        System.out.println(minOperations(6));
    }
}

// 2645. Minimum Additions to Make Valid String
package Medium;

public class Medium_2645_Minimum_Additions_to_Make_Valid_String {
    public static int addMinimum(String word) {
        char[] target = {'a', 'b', 'c'};
        int i = 0, j = 0, addOps = 0;

        while (i < word.length()) {
            if (word.charAt(i) == target[j]) {
                i++;
                j++;
            } else {
                j++;
                addOps++;
            }
            if (j == 3) j = 0;
        }
        if (j > 0) addOps += 3 - j;
        return addOps;
    }
    public static void main(String[] args) {
        System.out.println(addMinimum("b"));
        System.out.println(addMinimum("aaa"));
        System.out.println(addMinimum("abc"));
    }
}

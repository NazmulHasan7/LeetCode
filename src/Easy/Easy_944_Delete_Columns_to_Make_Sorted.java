// 944. Delete Columns to Make Sorted
package Easy;

public class Easy_944_Delete_Columns_to_Make_Sorted {
    public static int minDeletionSize(String[] strs) {
        int count = 0;
        int length = strs.length;
        int strLength = strs[0].length();
        char previous, current;
        for (int i = 0; i < strLength; i++) {
            previous = strs[0].charAt(i);
            for (int j = 1; j < length; j++) {
                current = strs[j].charAt(i);
                if (current < previous) {
                    count++;
                    break;
                } previous = current;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[] {"abc", "bce", "cae"}));
        System.out.println(minDeletionSize(new String[] {"cba","daf","ghi"}));
        System.out.println(minDeletionSize(new String[] {"a", "b"}));
        System.out.println(minDeletionSize(new String[] {"zyx","wvu","tsr"}));
    }
}

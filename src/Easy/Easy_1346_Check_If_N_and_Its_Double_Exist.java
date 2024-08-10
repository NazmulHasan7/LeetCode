// 1346. Check If N and Its Double Exist
package Easy;
import java.util.HashSet;

public class Easy_1346_Check_If_N_and_Its_Double_Exist {
    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int zeroCount = 0;
        for (int num : arr) {
            set.add(num);
            if (num == 0) zeroCount++;
        }
        for (int num : arr)
            if (num != 0 && set.contains(num * 2)) return true;
        return zeroCount >= 2;
    }
    public static boolean checkIfExistBetter(int[] arr) {
        int length = arr.length;
        for (int i=0; i<length; i++)
            for (int j=0; j<length; j++)
                if (i != j && (arr[i]*2 == arr[j]))
                    return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[] {10,2,5,3}));
        System.out.println(checkIfExist(new int[] {3,1,7,11}));
        System.out.println(checkIfExistBetter(new int[] {10,2,5,3}));
        System.out.println(checkIfExistBetter(new int[] {3,1,7,11,0}));
    }
}

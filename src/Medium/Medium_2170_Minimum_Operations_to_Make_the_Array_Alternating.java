// 2170. Minimum Operations to Make the Array Alternating
package Medium;
import java.util.HashMap;
import java.util.Map;

public class Medium_2170_Minimum_Operations_to_Make_the_Array_Alternating {
    public static int minimumOperations(int[] nums) {
        int n = nums.length;
        // if (n <= 1) return 0;
        HashMap<Integer, int[]> map = new HashMap<>();
        // frequencies
        int evenMaxFreq = 0, even2ndMaxFreq = 0;
        int oddMaxFreq = 0, odd2ndMaxFreq = 0;
        // numbers
        int evenNum = -1;
        int oddNum = -1;

        for (int i=0; i<n; i++) {
            int parity = i & 1;

            if (!map.containsKey(nums[i]))
                map.put(nums[i], new int[]{0,0});
            map.get(nums[i])[parity]++;
        }

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int key = entry.getKey();
            int[] freq = map.get(key);
            int ef = freq[0], of = freq[1];

            // update for even
            if (ef > evenMaxFreq) {
                even2ndMaxFreq = evenMaxFreq;
                evenMaxFreq = ef;
                evenNum = key;
            } else if (ef > even2ndMaxFreq) {
                even2ndMaxFreq = ef;
            }

            // update for odd
            if (of > oddMaxFreq) {
                odd2ndMaxFreq = oddMaxFreq;
                oddMaxFreq = of;
                oddNum = key;
            } else if (of > odd2ndMaxFreq) {
                odd2ndMaxFreq = of;
            }
        }

        int evenLen = Math.ceilDiv(n, 2);
        int oddLen = nums.length - evenLen;

        if (evenNum != oddNum) {
            return evenLen - evenMaxFreq + oddLen - oddMaxFreq;
        } else {
            int option1 = evenLen - even2ndMaxFreq + oddLen - oddMaxFreq;
            int option2 = evenLen - evenMaxFreq + oddLen - odd2ndMaxFreq;
            return Math.min(option1, option2);
        }
    }
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{3,1,3,2,4,3}));
        System.out.println(minimumOperations(new int[]{1,2,2,2,2}));
        System.out.println(minimumOperations(new int[]{1}));
    }
}

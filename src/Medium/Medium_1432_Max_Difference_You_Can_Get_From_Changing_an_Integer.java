// 1432. Max Difference You Can Get From Changing an Integer
package Medium;

public class Medium_1432_Max_Difference_You_Can_Get_From_Changing_an_Integer {
    public static int maxDiff(int num) {
        char[] nrr = String.valueOf(num).toCharArray();
        int n = nrr.length;

        // Find the max number
        for (int i=0; i<n; i++) {
            if (nrr[i] != '9') {
                for (int j=i+1; j<n; j++) {
                    if (nrr[j] == nrr[i])
                        nrr[j] = '9';
                }
                nrr[i] = '9';
                break;
            }
        }
        int maxNumber = Integer.parseInt(String.valueOf(nrr));
        nrr = String.valueOf(num).toCharArray();

        // Find the min number
        if (nrr[0] != '1') {
            for (int i=1; i<n; i++) {
                if (nrr[i] == nrr[0])
                    nrr[i] = '1';
            }
            nrr[0] = '1';
        } else {
            for (int i=1; i<n; i++) {
                if (nrr[i] > '1') {
                    for (int j=i+1; j<n; j++) {
                        if (nrr[j] == nrr[i])
                            nrr[j] = '0';
                    }
                    nrr[i] = '0';
                    break;
                }
            }
        }
        int minNumber = Integer.parseInt(String.valueOf(nrr));
        return maxNumber - minNumber;
    }
    public static void main(String[] args) {
        System.out.println(maxDiff(555));
        System.out.println(maxDiff(9));
    }
}

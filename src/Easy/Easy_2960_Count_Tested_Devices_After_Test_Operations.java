// 2960. Count Tested Devices After Test Operations
package Easy;

public class Easy_2960_Count_Tested_Devices_After_Test_Operations {
    public static int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        for (int i=0; i<batteryPercentages.length; i++) {
            if (batteryPercentages[i]-count > 0) count++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countTestedDevices(new int[] {0,1,2}));
        System.out.println(countTestedDevices(new int[] {1,1,2,1,3}));
    }
}

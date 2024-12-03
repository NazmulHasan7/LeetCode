// 134. Gas Station
package Medium;

public class Medium_134_Gas_Station {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int costSum = 0, gasSum = 0;
        for (int g : gas) gasSum += g;
        for (int c : cost) costSum += c;

        // if total cost > total gas then it is impossible to complete the circuit
        if (costSum > gasSum) return -1;

        // if not, then there is at least one solution
        int answer = 0, tank = 0;
        for (int i=0; i<gas.length; i++) {
            tank += (gas[i] - cost[i]);

            if (tank < 0) {
                tank = 0;
                answer = i+1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }
}

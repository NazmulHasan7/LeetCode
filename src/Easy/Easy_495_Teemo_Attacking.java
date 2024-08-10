// 495. Teemo Attacking
package Easy;

public class Easy_495_Teemo_Attacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int answer = 0;
        for (int i=0; i<timeSeries.length-1; i++)
            // If next attack takes place before current attack duration ends
            answer += Math.min(timeSeries[i+1] - timeSeries[i], duration);
        return answer + duration;
    }
    public static int findPoisonedDurationX(int[] timeSeries, int duration) {
        int answer = 0;
        for (int i=0; i<timeSeries.length-1; i++) {
            // If next attack takes place before current attack duration ends
            if (timeSeries[i+1] <= timeSeries[i]+duration-1)
                answer += timeSeries[i+1] - timeSeries[i];
            else answer += duration;
        } return answer + duration;
    }
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[] {1,4}, 2));
        System.out.println(findPoisonedDuration(new int[] {1,2}, 2));
    }
}

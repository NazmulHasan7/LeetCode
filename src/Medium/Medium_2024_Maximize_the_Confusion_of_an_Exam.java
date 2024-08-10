// 2024. Maximize the Confusion of an Exam
package Medium;

public class Medium_2024_Maximize_the_Confusion_of_an_Exam {
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int answer = 0, count = 0;
        int left = 0, right = 0;
        char[] crr = answerKey.toCharArray();

        // Considering -> true case
        while (right < n) {
            if (crr[right] == 'F')
                count++;
            while (count > k) {
                if (crr[left] == 'F')
                    count--;
                left++;
            } answer = Math.max(answer, right-left+1);
            right++;
        }
        // Considering -> false case
        left = right = count = 0;
        while (right < n) {
            if (crr[right] == 'T')
                count++;
            while (count > k) {
                if (crr[left] == 'T')
                    count--;
                left++;
            } answer = Math.max(answer, right-left+1);
            right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFF", 2));
        System.out.println(maxConsecutiveAnswers("TFFT", 1));
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}

// 845. Longest Mountain in Array
package Medium;

public class Medium_845_Longest_Mountain_in_Array {
    public static int longestMountain(int[] arr) {
        int up=0, down=0, answer=0;
        for (int i=1; i<arr.length; i++) {
            // If any sudden up is encountered while descending
            // Or a flatted land is seen then reset up and down to 0
            if ((down>0 && arr[i-1]<arr[i]) || arr[i-1]==arr[i])
                up = down = 0;

            if (arr[i-1] < arr[i]) up++;
            else if (arr[i-1] > arr[i]) down++;
            if (up>0 && down>0 && up+down+1>answer)
                answer = up + down + 1;
        } return answer;
    }
    public static int longestMountainBruteForce(int[] arr) {
        int answer=0, start, end;
        for (int i=1; i<arr.length-1; i++) {
            if (arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                start = i-1;
                end = i+1;
                // Considering i as peak --> decreasing should be in left
                while (start > 0 && arr[start] > arr[start-1])
                    start--;
                // Considering i as peak --> decreasing should be in right
                while (end < arr.length-1 && arr[end] > arr[end+1])
                    end++;
                answer = Math.max(answer, end-start+1);
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(longestMountain(new int[]{2,2,2}));
        System.out.println(longestMountainBruteForce(new int[]{2,1,4,7,3,2,5}));
        System.out.println(longestMountainBruteForce(new int[]{2,2,2}));
    }
}

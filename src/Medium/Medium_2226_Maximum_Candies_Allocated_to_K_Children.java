// 2226. Maximum Candies Allocated to K Children
package Medium;

public class Medium_2226_Maximum_Candies_Allocated_to_K_Children {
    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int max = 0;
        for (int candy : candies) {
            sum += candy;
            max = Math.max(max, candy);
        }
        if (sum < k) return 0;
        int start = 1, end = max, answer = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long count = 0;
            for (int candy : candies)
                count += candy / mid;

            if (count >= k) {
                answer = mid;
                start = mid + 1;
            } else end = mid - 1;
        } return answer;
    }
    public static int maximumCandiesBetter(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) sum += candy;
        if (sum < k) return 0;

        int start = 1, end = (int)(sum/k);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long count = 0;
            for (int candy : candies)
                count += candy / mid;

            if (count >= k) start = mid + 1;
            else end = mid - 1;
        } return end;
    }
    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[]{5,8,6},3));
        System.out.println(maximumCandies(new int[]{2,5},11));
        System.out.println(maximumCandiesBetter(new int[]{5,8,6},3));
        System.out.println(maximumCandiesBetter(new int[]{2,5},11));
    }
}

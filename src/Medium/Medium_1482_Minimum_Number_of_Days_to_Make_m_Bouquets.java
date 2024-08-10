// 1482. Minimum Number of Days to Make m Bouquets
package Medium;

public class Medium_1482_Minimum_Number_of_Days_to_Make_m_Bouquets {
    private static int getNumberOfBouquets(int[] bloomDay, int mid, int k) {
        int numberOfBouquets = 0;
        int count = 0;

        for (int day : bloomDay) {
            if (day <= mid) count++;
                // Since adjacent flowers can be used only
            else count = 0;
            if (count == k) {
                count = 0;
                numberOfBouquets++;
            }
        } return numberOfBouquets;
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int start = 0, end = 0;
        for (int day : bloomDay)
            if (day > end) end = day;

        int min = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = getNumberOfBouquets(bloomDay, mid, k);
            if (count >= m) {
                min = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } return min;
    }
    public int minDaysFaster(int[] bloom, int m, int k) {
        int low = 1, high = -1;
        for(int day : bloom)
            high = Math.max(high,day);

        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int bouquet = 0, count = 0;

            for(int i=0; i<bloom.length; i++) {
                while(i != bloom.length && bloom[i] <= mid) {
                    count++;
                    i++;
                } bouquet += (count/k);
                count = 0;
            }
            if(bouquet >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } return ans;
    }
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1,10,3,10,2},3,1));
        System.out.println(minDays(new int[]{1,10,3,10,2},3,2));
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7},2,3));
    }
}

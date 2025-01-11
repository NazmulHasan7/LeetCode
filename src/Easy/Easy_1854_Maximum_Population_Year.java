// 1854. Maximum Population Year
package Easy;

public class Easy_1854_Maximum_Population_Year {
    public static int maximumPopulation(int[][] logs) {
        // Stores the population in each year
        int[] year = new int[101]; // [1950, 2050]

        int minYear = 3000, maxYear = 0;
        for (int[] log : logs) {
            year[log[0]-1950]++; // birth
            year[log[1]-1950]--; // death
            minYear = Math.min(minYear, log[0]);
            maxYear = Math.max(maxYear, log[1]);
        }
        int maxPopYear = minYear;
        int maxPop = 0;
        int currentPop = 0;
        for (int y=minYear; y<=maxYear; y++) {
            currentPop += year[y-1950];
            if (currentPop > maxPop) {
                maxPop = currentPop;
                maxPopYear = y;
            }
        }
        return maxPopYear;
    }
    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{1993,1999},{2000,2010}}));
        System.out.println(maximumPopulation(new int[][]{{1950,1961},{1960,1971},{1970,1981}}));
    }
}

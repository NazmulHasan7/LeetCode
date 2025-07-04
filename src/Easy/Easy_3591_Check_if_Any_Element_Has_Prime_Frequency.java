// 3591. Check if Any Element Has Prime Frequency
package Easy;

public class Easy_3591_Check_if_Any_Element_Has_Prime_Frequency {
    public static boolean checkPrimeFrequency(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        int[] map = new int[101];
        for (int n : nums)
            // map.put(n, map.getOrDefault(n,0)+1);
            map[n]++;

        // for (int freq : map.values())
        for (int freq : map)
            if (freq > 1 && isPrime(freq))
                return true;
        return false;
    }
    private static boolean isPrime(int n) {
        for (int i=2; i*i<=n; i++)
            if (n % i == 0) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkPrimeFrequency(new int[]{1,2,3,4,5,4}));
        System.out.println(checkPrimeFrequency(new int[]{1,2,3,4,5}));
        System.out.println(checkPrimeFrequency(new int[]{2,2,2,4,4}));
    }
}

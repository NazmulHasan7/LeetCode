// 3223. Minimum Length of String After Operations
package Medium;

public class Medium_3223_Minimum_Length_of_String_After_Operations {
    // TC -> O(n), SC -> O(26) = O(1)
    public static int minimumLength(String s) {
        // HashMap<Character, Integer> map = new HashMap<>();
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            // map.put(c, map.getOrDefault(c,0)+1);
            freq[c-'a']++;

        int minLength = 0;
        // To delete the closest left and right, we need to have at least 3 occurrence of the character
        // for (char c : map.keySet()) {
        for (int count : freq) {
            // int count = map.get(c);
            while (count >= 3)
                count -= 2;
            minLength += count;
        }
        return minLength;
    }
    public static void main(String[] args) {
        System.out.println(minimumLength("abaacbcbb"));
        System.out.println(minimumLength("aa"));
    }
}

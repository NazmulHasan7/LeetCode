// 2418. Sort the People
package Easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Easy_2418_Sort_the_People {
    public static String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> tMap = new TreeMap<>();
        for (int i=0; i<heights.length; i++)
            tMap.put(heights[i], names[i]);
        int index = 0;
        for (int height : tMap.descendingKeySet())
            names[index++] = tMap.get(height);
        return names;
    }
    public static String[] sortPeopleBetter(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        int length = heights.length;
        for (int i=0; i<length; i++)
            map.put(heights[i], names[i]);
        Arrays.sort(heights);
        int index = 0;
        for (int i=length-1; i>=0; i--)
            names[index++] = map.get(heights[i]);
        return names;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortPeopleBetter(
                new String[] {"Mary","John","Emma"}, new int[] {180, 165, 170})));
        System.out.println(Arrays.toString(sortPeopleBetter(
                new String[] {"Alice","Bob","Bob"}, new int[] {155, 185, 150})));
        System.out.println(Arrays.toString(sortPeople(
                new String[] {"Mary","John","Emma"}, new int[] {180, 165, 170})));
        System.out.println(Arrays.toString(sortPeople(
                new String[] {"Alice","Bob","Bob"}, new int[] {155, 185, 150})));
    }
}

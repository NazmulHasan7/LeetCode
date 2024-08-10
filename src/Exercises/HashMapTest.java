package Exercises;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("GP", "017");
        map.put("BL", "019");
        map.put("RB", "018");
        map.put("AR", "016");
        map.put("TK", "015");
        System.out.println(map);

        if (!map.containsKey("CT"))
            System.out.println("Key doesn't exist");
        else System.out.println("Exists");

        map.remove("AR");
        System.out.println("Size : " + map.size());
        for (Map.Entry<String, String> e : map.entrySet())
            System.out.println(e);
    }
}

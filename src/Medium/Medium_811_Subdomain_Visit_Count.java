// 811. Subdomain Visit Count
package Medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium_811_Subdomain_Visit_Count {
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String cpd : cpdomains) {
            String[] arr = cpd.split(" ");
            int count = Integer.parseInt(arr[0]);

            StringBuilder sb = new StringBuilder(arr[1]);
            while (!sb.isEmpty()) {
                int x = sb.indexOf(".");
                map.put(sb.toString(), map.getOrDefault(sb.toString(),0) + count);
                if (x == -1) break;
                sb.delete(0, x+1);
            }
        }
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet())
            answer.add(entry.getValue() + " " + entry.getKey());
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }
}

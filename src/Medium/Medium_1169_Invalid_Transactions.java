// 1169. Invalid Transactions
package Medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium_1169_Invalid_Transactions {
    private static final int MAX_AMOUNT = 1000;
    private static final int MIN_TIME_GAP = 60;
    private static final int NAME = 0;
    private static final int TIME = 1;
    private static final int AMOUNT = 2;
    private static final int CITY = 3;

    private static class Transaction {
        int id;
        String name;
        int time;
        int amount;
        String city;

        Transaction(int id, String name, int time, int amount, String city) {
            this.id = id;
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }
    public static List<String> invalidTransactions(String[] transactions) {
        // Invalid case -> same name, transaction within 60 minutes
        // Amount > 1000$
        Map<String, List<Transaction>> map = new HashMap<>();

        for (int i=0; i<transactions.length; i++) {
            String[] details = transactions[i].split(",");
            Transaction entry = new Transaction(
                    i,
                    details[NAME],
                    Integer.parseInt(details[TIME]),
                    Integer.parseInt(details[AMOUNT]),
                    details[CITY]
            );
            map.computeIfAbsent(entry.name,
                    k -> new ArrayList<>()).add(entry);
        }
        return getInvalidTransactions(transactions, map);
    }

    private static List<String> getInvalidTransactions(String[] transactions, Map<String, List<Transaction>> map) {
        List<String> invalids = new ArrayList<>();
        for (Map.Entry<String, List<Transaction>> entry : map.entrySet()) {
            for (Transaction t : entry.getValue()) {
                if (t.amount > MAX_AMOUNT) {
                    invalids.add(transactions[t.id]);
                    continue;
                }
                for (Transaction other : entry.getValue()) {
                    if (t.id != other.id && Math.abs(t.time - other.time) <= MIN_TIME_GAP && !t.city.equals(other.city)) {
                        invalids.add(transactions[t.id]);
                        break;
                    }
                }
            }
        }
        return invalids;
    }

    public static void main(String[] args) {
        System.out.println(invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"}));
        System.out.println(invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,1200,mtv"}));
        System.out.println(invalidTransactions(new String[]{"alice,20,800,mtv","bob,50,1200,mtv"}));
    }
}

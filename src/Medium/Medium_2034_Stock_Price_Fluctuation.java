// 2034. Stock Price Fluctuation
package Medium;
import java.util.HashMap;
import java.util.TreeSet;

public class Medium_2034_Stock_Price_Fluctuation {
    static class StockPrice {
        int currentTime;
        int currentPrice;
        TreeSet<Integer> set; // keep track of unique prices
        HashMap<Integer, Integer> map; // timestamp, price map
        HashMap<Integer, Integer> priceFreq; // keep track of price frequency

        public StockPrice() {
            currentPrice = -1;
            currentTime = -1;
            set = new TreeSet<>();
            map = new HashMap<>();
            priceFreq = new HashMap<>();
        }

        public void update(int timestamp, int price) {
            if (timestamp >= currentTime) {
                currentPrice = price;
                currentTime = timestamp;
            }
            // update the old price
            if (map.containsKey(timestamp)) {
                int oldPrice = map.get(timestamp);
                int freq = priceFreq.get(oldPrice);
                if (freq == 1) {
                    priceFreq.remove(oldPrice);
                    set.remove(oldPrice);
                } else {
                    priceFreq.put(oldPrice, freq-1);
                }
            }
            set.add(price);
            map.put(timestamp, price);
            priceFreq.put(price, priceFreq.getOrDefault(price,0)+1);
        }

        public int current() {
            return currentPrice;
        }

        public int maximum() {
            return set.last();
        }

        public int minimum() {
            return set.first();
        }
    }
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        System.out.println(stockPrice.current());     // return 5, the latest timestamp is 2 with the price being 5.
        System.out.println(stockPrice.maximum());     // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        System.out.println(stockPrice.maximum());     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        System.out.println(stockPrice.minimum());     // return 2, the minimum price is 2 at timestamp 4.
    }
}

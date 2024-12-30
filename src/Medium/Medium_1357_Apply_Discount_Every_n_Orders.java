// 1357. Apply Discount Every n Orders
package Medium;

public class Medium_1357_Apply_Discount_Every_n_Orders {
    static class Cashier {
        private final int n;
        private final int discount;
        private int billCount = 0;
        // HashMap<Integer, Integer> productPriceMap;
        private int[] prices;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = discount;
            // this.productPriceMap = new HashMap<>();
            this.prices = new int[201];

            for (int i=0; i<products.length; i++)
                // productPriceMap.put(products[i], prices[i]);
                this.prices[products[i]] = prices[i];
        }

        public double getBill(int[] product, int[] amount) {
            double bill = 0;
            billCount++;

            // Calculate the bill amount
            for (int i=0; i<product.length; i++) {
                // double unitPrice = this.productPriceMap.get(product[i]);
                double unitPrice = this.prices[product[i]];
                bill += (unitPrice * amount[i]);
            }
            // Calculate discount
            if (billCount % n == 0)
                bill *= (100 - discount) / 100.0;
            return bill;
        }
    }
    public static void main(String[] args) {
        Cashier cashier = new Cashier(3,50,
                new int[]{1,2,3,4,5,6,7},
                new int[]{100,200,300,400,300,200,100}
        );
        System.out.println(cashier.getBill(new int[]{1,2}, new int[]{1,2}));
        System.out.println(cashier.getBill(new int[]{3,7}, new int[]{10,10}));
        System.out.println(cashier.getBill(new int[]{1,2,3,4,5,6,7}, new int[]{1,1,1,1,1,1,1}));
        System.out.println(cashier.getBill(new int[]{4}, new int[]{10}));
        System.out.println(cashier.getBill(new int[]{7,3}, new int[]{10,10}));
        System.out.println(cashier.getBill(new int[]{7,5,3,1,6,4,2}, new int[]{10,10,10,9,9,9,7}));
        System.out.println(cashier.getBill(new int[]{2,3,5}, new int[]{5,3,2}));
    }
}

// 2526. Find Consecutive Integers from a Data Stream
package Medium;

public class Medium_2526_Find_Consecutive_Integers_from_a_Data_Stream {
    static class DataStream {
        int value, k, count = 0;
        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
            count = 0;
        }
        public boolean consec(int num) {
            if (value == num) count++;
            else count = 0;
            System.out.println(count >= k);
            return count >= k;
        }
    }
    public static void main(String[] args) {
        DataStream dataStream = new DataStream(4, 3); //value = 4, k = 3
        dataStream.consec(4); // Only 1 integer is parsed, so returns False.
        dataStream.consec(4); // Only 2 integers are parsed.
        // Since 2 is less than k, returns False.
        dataStream.consec(4); // The 3 integers parsed are all equal to value, so returns True.
        dataStream.consec(3); // The last k integers parsed in the stream are [4,4,3].
        // Since 3 is not equal to value, it returns False.
    }
}

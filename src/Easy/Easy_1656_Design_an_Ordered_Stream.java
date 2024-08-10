// 1656. Design an Ordered Stream
package Easy;

public class Easy_1656_Design_an_Ordered_Stream {
    static class OrderedStream {
        String[] stream;
        int ptr = 0;
        public OrderedStream(int n) {
            stream = new String[n];
        }
        public String[] insert(int idKey, String value) {
            stream[idKey-1] = value;
            // List<String> result = new ArrayList<>();

            int oldPtr = ptr;
            while (ptr < stream.length && stream[ptr] != null)
                // result.add(stream[ptr++]);
                ptr++;
            String[] result = new String[ptr-oldPtr];
            System.arraycopy(stream, oldPtr, result, 0, ptr-oldPtr);
            return result;
        }
    }
    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        os.insert(3, "ccccc");
        os.insert(1, "aaaaa");
        os.insert(2, "bbbbb");
        os.insert(5, "eeeee");
        os.insert(4, "ddddd");
    }
}

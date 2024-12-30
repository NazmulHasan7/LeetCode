// 284. Peeking Iterator
package Medium;
import java.util.Arrays;
import java.util.Iterator;

public class Medium_284_Peeking_Iterator {
    static class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private Integer nextNumber;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (iterator.hasNext())
                nextNumber = iterator.next();
        }
        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextNumber;
        }
        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer answer = nextNumber;
            if (iterator.hasNext())
                nextNumber = iterator.next();
            else nextNumber = null;
            return answer;
        }
        @Override
        public boolean hasNext() {
            return nextNumber != null;
        }
    }
    public static void main(String[] args) {
        PeekingIterator peekingIterator = new PeekingIterator(Arrays.asList(1, 2, 3).iterator()); // [1,2,3]
        peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
        peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
        peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
        peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.hasNext());;
    }
}

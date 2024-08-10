// 341. Flatten Nested List Iterator
package Medium;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Medium_341_Flatten_Nested_List_Iterator {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    static class NestedIterator implements Iterator<Integer> {
        List<Integer> flattenedList;
        int size;
        int pointer;
        public NestedIterator(List<NestedInteger> nestedList) {
            flattenedList = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    flattenedList.add(ni.getInteger());
                } else {
                    NestedIterator iter = new NestedIterator(ni.getList());
                    flattenedList.addAll(iter.flattenedList);
                }
                pointer = 0;
                size = flattenedList.size();
            }
        }
        @Override
        public Integer next() {
            return flattenedList.get(pointer++);
        }
        @Override
        public boolean hasNext() {
            return pointer < size;
        }
    }
}

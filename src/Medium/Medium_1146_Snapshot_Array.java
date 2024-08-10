// 1146. Snapshot Array
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_1146_Snapshot_Array {
    static class Pair {
        int val, snapId;
        public Pair(int val, int snapId) {
            this.val = val;
            this.snapId = snapId;
        }
    }
    static class SnapshotArray {
        List[] snapArrays;
        int snapId;
        public SnapshotArray(int length) {
            snapArrays = new ArrayList[length];
            snapId = 0;
        }
        public void set(int index, int val) {
            if (snapArrays[index] == null)
                snapArrays[index] = new ArrayList<>();
            snapArrays[index].add(new Pair(val, snapId));
        }
        public int snap() {
            return snapId++;
        }
        public int get(int index, int snap_id) {
            if (snapArrays[index] == null)
                return 0;

            List array = snapArrays[index];
            int start = 0, end = array.size()-1;

            while (start <= end) {
                int mid = (start+end) / 2;
                Pair pair = (Pair) array.get(mid);
                if (pair.snapId <= snap_id)
                    start = mid + 1;
                else end = mid - 1;
            }
            return start == 0 ? 0 : ((Pair) array.get(start-1)).val;
        }
    }
    public static void main(String[] args) {
        SnapshotArray snap = new SnapshotArray(3);
        snap.set(0,5);
        System.out.println(snap.snap());
        snap.set(0,6);
        System.out.println(snap.get(0,0));
    }
}

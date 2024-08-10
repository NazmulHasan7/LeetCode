// 1496. Path Crossing
package Easy;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Easy_1496_Path_Crossing {
    public static boolean isPathCrossingBetter(String path) {
        Pair pair = new Pair(0,0);
        Set<Pair> set = new HashSet<>();
        set.add(pair);
        for(char s: path.toCharArray()){
            if(s == 'N')
                pair = new Pair(pair.x, pair.y+1);
            else if(s == 'S')
                pair = new Pair(pair.x, pair.y-1);
            else if(s == 'E')
                pair = new Pair(pair.x+1, pair.y);
            else
                pair = new Pair(pair.x-1, pair.y);
            if(!set.add(pair))
                return true;
        } return false;
    }
    public static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            Pair other = (Pair) obj;
            return x == other.x && y == other.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }
    public static boolean isPathCrossing(String path) {
        Set<String> visitedPoint = new HashSet<>();
        visitedPoint.add("0,0");
        char c;
        int x = 0, y = 0;
        for (int i=0; i<path.length(); i++) {
            c = path.charAt(i);
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else x--;
            if (!visitedPoint.add((x + "," + y)))
                return true;
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
        System.out.println(isPathCrossing("NESWW"));
        System.out.println(isPathCrossingBetter("NES"));
        System.out.println(isPathCrossingBetter("NESWW"));
    }
}

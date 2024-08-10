// 1476. Subrectangle Queries
package Medium;

public class Medium_1476_Subrectangle_Queries {
    static class SubrectangleQueries {
        int[][] rectangle;
        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }
        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int r=row1; r<=row2; r++)
                for (int c=col1; c<=col2; c++)
                    rectangle[r][c] = newValue;
        }
        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
        public void print() {
            for (int r=0; r<rectangle.length; r++) {
                for (int c = 0; c <rectangle[r].length; c++)
                    System.out.print(rectangle[r][c] + " ");
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(
                new int[][] {{1,1,1},{2,2,2},{3,3,3}});
        System.out.println(subrectangleQueries.getValue(0, 0)); // return 1
        subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
        subrectangleQueries.print();
        System.out.println(subrectangleQueries.getValue(0, 0)); // return 100
        System.out.println(subrectangleQueries.getValue(2, 2)); // return 100
        subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
        subrectangleQueries.print();
        System.out.println(subrectangleQueries.getValue(2, 2)); // return 20
    }
}

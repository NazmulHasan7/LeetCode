// 3484. Design Spreadsheet
package Medium;

public class Medium_3484_Design_Spreadsheet {
    static class Spreadsheet {
        private static int[][] sheet;

        public Spreadsheet(int rows) {
            sheet = new int[rows+1][26];
        }
        public void setCell(String cell, int value) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1));
            sheet[row][col] = value;
        }
        public void resetCell(String cell) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1));
            sheet[row][col] = 0;
        }
        public int getValue(String formula) {
            String[] args = formula.split("\\+");
            String x = args[0].substring(1), y = args[1];
            int xVal = 0, yVal = 0;

            if (Character.isAlphabetic(x.charAt(0))) {
                int col = x.charAt(0) - 'A';
                int row = Integer.parseInt(x.substring(1));
                xVal = sheet[row][col];
            } else {
                xVal = Integer.parseInt(x);
            }

            if (Character.isAlphabetic(y.charAt(0))) {
                int col = y.charAt(0) - 'A';
                int row = Integer.parseInt(y.substring(1));
                yVal = sheet[row][col];
            } else {
                yVal = Integer.parseInt(y);
            }
            return xVal + yVal;
        }
    }
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3); // Initializes a spreadsheet with 3 rows and 26 columns
        spreadsheet.getValue("=5+7"); // returns 12 (5+7)
        spreadsheet.setCell("A1", 10); // sets A1 to 10
        spreadsheet.getValue("=A1+6"); // returns 16 (10+6)
        spreadsheet.setCell("B2", 15); // sets B2 to 15
        spreadsheet.getValue("=A1+B2"); // returns 25 (10+15)
        spreadsheet.resetCell("A1"); // resets A1 to 0
        spreadsheet.getValue("=A1+B2"); // returns 15 (0+15)
    }
}

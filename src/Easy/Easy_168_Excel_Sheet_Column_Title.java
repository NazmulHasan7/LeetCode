// 168. Excel Sheet Column Title
package Easy;

public class Easy_168_Excel_Sheet_Column_Title {
    public static String convertToTitle(int columnNumber) {
        StringBuilder columnName = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--; // O index
            columnName.insert(0, (char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        } return columnName.toString();
    }
    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
    }
}

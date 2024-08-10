// 1678. Goal Parser Interpretation
package Easy;

public class Easy_1678_Goal_Parser_Interpretation {
    public static String interpret(String command) {
        StringBuilder str = new StringBuilder();
        int length = command.length();

        for (int i=0; i<length; i++) {
            if (command.charAt(i) == '(') {
                if (command.charAt(i+1) == ')') {
                    str.append("o");
                    i++;
                } else if (command.charAt(i+1) == 'a') {
                    str.append("al");
                    i += 3;
                }
            } else str.append("G");
        } return str.toString();
    }
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
        System.out.println(interpret("G()()()()(al)"));
        System.out.println(interpret("(al)G(al)()()G"));
    }
}

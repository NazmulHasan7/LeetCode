// 722. Remove Comments
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_722_Remove_Comments {
    public static List<String> removeComments(String[] source) {
        List<String> answer = new ArrayList<>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlockComment = false;

        for (String line : source) {
            int len = line.length();
            if (!inBlockComment)
                newLine = new StringBuilder();

            for (int i=0; i<len; i++) {
                char c = line.charAt(i);
                if (!inBlockComment) {
                    if (c == '/') {
                        // check for single line comment
                        if (i+1 < len && line.charAt(i+1) == '/') {
                            break;
                        } else if (i+1 < len && line.charAt(i+1) == '*') {
                            i+=2;
                            inBlockComment = true;
                        } else { // can be a valid operator
                            newLine.append(c);
                        }
                    } else {
                        newLine.append(c);
                    }
                } else if (c == '*') {
                    if (i+1 < len && line.charAt(i+1) == '/') {
                        i++;
                        inBlockComment = false;
                    }
                }
            }
            if (!inBlockComment && !newLine.isEmpty())
                answer.add(newLine.toString());
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(removeComments(new String[]{"/*Test program */", "int main()",
                "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test",
                "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));

        System.out.println(removeComments(new String[]{"a/*comment", "line", "more_comment*/b"}));
    }
}

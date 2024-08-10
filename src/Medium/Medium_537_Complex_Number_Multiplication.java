// 537. Complex Number Multiplication
package Medium;

public class Medium_537_Complex_Number_Multiplication {
    public static String complexNumberMultiply(String num1, String num2) {
        int n1Idx = num1.indexOf('+');
        int r1 = Integer.parseInt(num1.substring(0, n1Idx));
        int i1 = Integer.parseInt(num1.substring(n1Idx+1, num1.length()-1));

        int n2Idx = num2.indexOf('+');
        int r2 = Integer.parseInt(num2.substring(0, n2Idx));
        int i2 = Integer.parseInt(num2.substring(n2Idx+1, num2.length()-1));

        int real = (r1*r2) + (i1*i2) * (-1);
        int imaginary = r1*i2 + r2*i1;
        return real + "+" + imaginary + "i";
    }
    public static String complexNumberMultiplyBetter(String num1, String num2) {
        int r1 = Integer.parseInt(num1.substring(0,num1.indexOf('+')));
        int i1 = Integer.parseInt(num1.substring(num1.indexOf('+')+1,num1.length()-1));
        int r2 = Integer.parseInt(num2.substring(0,num2.indexOf('+')));
        int i2 = Integer.parseInt(num2.substring(num2.indexOf('+')+1,num2.length()-1));

        StringBuilder sb = new StringBuilder();
        sb.append((r1*r2) - (i1*i2));
        sb.append('+');
        sb.append((r1*i2) + (r2*i1));
        sb.append('i');
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(complexNumberMultiplyBetter("1+1i", "1+1i"));
        System.out.println(complexNumberMultiplyBetter("1+-1i", "1+-1i"));
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }
}

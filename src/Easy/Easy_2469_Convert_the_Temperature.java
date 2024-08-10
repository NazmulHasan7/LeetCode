// 2469. Convert the Temperature
package Easy;
import java.util.Arrays;

public class Easy_2469_Convert_the_Temperature {
    public static double[] convertTemperature(double celsius) {
        return new double[] {celsius + 273.15, celsius * 1.80 + 32.00};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(convertTemperature(36.50)));
        System.out.println(Arrays.toString(convertTemperature(122.11)));
    }
}

// 1108. Defanging an IP Address
package Easy;

public class Easy_1108_Defanging_an_IP_Address {
    public static String defangIPaddr(String address) {
       return address.replace(".", "[.]");
    }
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
    }
}

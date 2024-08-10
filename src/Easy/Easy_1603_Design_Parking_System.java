// 1603. Design Parking System
package Easy;

public class Easy_1603_Design_Parking_System {
    static class ParkingSystem {
        int big, medium, small;
        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }
        public boolean addCar(int carType) {
            return switch (carType) {
                case 1 -> this.big-- > 0;
                case 2 -> this.medium-- > 0;
                case 3 -> this.small-- > 0;
                default -> false;
            };
        }
    }
    public static void main(String[] args) {
        ParkingSystem ps = new ParkingSystem(1,1,0);
        System.out.println(ps.addCar(1));
        System.out.println(ps.addCar(2));
        System.out.println(ps.addCar(3));
        System.out.println(ps.addCar(1));
    }
}

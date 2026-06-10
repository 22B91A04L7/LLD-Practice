class Vehicle {
    public void start() {
        System.out.println(" Car is Starting");
    }

    public void drive() {
        System.out.println(" Car is in Driving Mode");
    }

    public void stop() {
        System.out.println(" is Stopping");
    }
}

class ManualCar extends Vehicle {

    public void petrolLevel() {
        System.out.println("Petrol Level is Showing");
    }
}

class ElectricCar extends Vehicle {

    public void batteryLevel() {
        System.out.println("Battery Level is Showing");
    }

}

public class Main {
    public static void main(String[] args) {
        ManualCar obj1 = new ManualCar();
        obj1.start();
        obj1.drive();
        obj1.petrolLevel();
        obj1.stop();

        ElectricCar obj2 = new ElectricCar();
        obj2.start();
        obj2.drive();
        obj2.batteryLevel();
        obj2.stop();
    }
}

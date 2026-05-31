class Car {
    private String model;
    private int speed;
    private boolean isStarted;
    private int gear;

    public Car(String model) {
        this.model = model;
        this.speed = 0;
        this.gear = 0;
        this.isStarted = false;
    }

    public void start() {
        isStarted = true;
        System.out.println(model + " Car is Started");
    }

    public void accelerate(int initialSpeed) {
        if (isStarted) {
            this.speed += initialSpeed;
            System.out.println("Car is accelerated to " + speed + "Kmph");
        } else {
            System.out.println("Start the car first");
        }
    }

    public void drive() {
        if (isStarted && speed > 0) {
            System.out.println(model + " is moving with " + speed + " Kmph");
        } else {
            System.out.println("Cannot Drive");
        }
    }

    public void gearShift(int gear) {
        if (isStarted) {
            if (gear > 4 || gear < 1) {
                System.out.println("Out of gear Range...cannot shift");
            } else {
                this.gear = gear;
                System.out.println("Gear shifted to " + gear);
            }
        } else {
            System.out.println("start the car first");
        }
    }

    public void stop() {
        speed = 0;
        isStarted = false;
        gear = 0;
        System.out.println(model + " is Stopped");
    }

}

class Driver {
    private Car car;
    private String name;

    public Driver(Car car, String name) {
        this.car = car;
        this.name = name;
    }

    public void driveCar() {
        System.out.println(name + " is Driving the Car");
        car.start();
        car.gearShift(1);
        car.accelerate(10);
        car.drive();
        car.gearShift(2);
        car.accelerate(20);
        car.drive();
        car.gearShift(4);
        car.drive();
        car.stop();
        car.gearShift(3);
        car.accelerate(40);
        car.gearShift(0);
    }
}

public class Main {
    public static void main(String args[]) {
        Car car = new Car("BMW");
        Driver driver = new Driver(car, "Venkat");
        driver.driveCar();
    }
}

abstract class Vehicle {
    public abstract void start();

    public abstract void shiftGear(int gear);

    public abstract void accelerate(int speed);

    public abstract void drive();

    public abstract void brake(int speed);

    public abstract void stop();
}

class Car extends Vehicle {
    private String model;
    private int currSpeed;
    private int currGear;
    private boolean isStarted;

    public Car(String model) {
        this.model = model;
        currGear = 0;
        currSpeed = 0;
        isStarted = false;
    }

    @Override
    public String toString() {
        return model;
    }

    @Override
    public void start() {
        if (!isStarted) {
            isStarted = true;
            System.out.println(model + " Engine is Started");
        } else {
            System.out.println(model + " Engine is already started");
        }
    }

    @Override
    public void shiftGear(int gear) {
        if (isStarted) {
            if (gear < 1 || gear > 4) {
                System.out.println("Gear out of range !! cannot shift");
            } else {
                currGear = gear;
                System.out.println("Car shifted to " + currGear);
            }
        } else {
            System.out.println("Start the car first");
        }
    }

    @Override
    public void accelerate(int speed) {
        if (isStarted) {
            currSpeed += speed;
            System.out.println("Accelerated by " + speed + " Kmph");
        } else {
            System.out.println("Start the car first");
        }
    }

    @Override
    public void drive() {
        if (!isStarted) {
            System.out.println("Car not started");
        } else if (currSpeed == 0) {
            System.out.println("Car is not moving but engine started!!");
        } else {
            System.out.println("Car is moving at " + currSpeed + " Kmph");
        }
    }

    @Override
    public void brake(int speed) {
        if (isStarted) {
            currSpeed -= speed;
            System.out.println("Brakes Applied !! Current Speed is " + currSpeed);
        } else {
            System.out.println("cannot Apply !! car not started");
        }
    }

    @Override
    public void stop() {
        if (isStarted) {
            currGear = 0;
            currSpeed = 0;
            isStarted = false;
            System.out.println("Car stopped !!!");
        } else {
            System.out.println("Car is aleady stopped");
        }
    }
}

class Driver {
    private String name;
    private Vehicle vehicle;

    public Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public void driveVehicle() {
        System.out.println(name + " is driving " + vehicle);
        vehicle.start();
        vehicle.shiftGear(1);
        vehicle.accelerate(10);
        vehicle.drive();
        vehicle.shiftGear(4);
        vehicle.accelerate(50);
        vehicle.drive();
        vehicle.brake(10);
        vehicle.drive();
        vehicle.stop();
    }
}

public class Main {
    public static void main(String args[]) {
        Vehicle vehicle = new Car("TOYOTO");
        Driver driver = new Driver("Venkat", vehicle);
        driver.driveVehicle();
    }
}

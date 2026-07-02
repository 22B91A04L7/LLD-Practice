//strategy for different vehicles
interface RouteStrategy {
    void navigate();
}

// car route strategy
class CarRoute implements RouteStrategy {
    public void navigate() {
        System.out.println("Finding fastest Car Route..!!! ");
    }
}
// Bike route strategy

class BikeRoute implements RouteStrategy {
    public void navigate() {
        System.out.println("Finding bike-friendly route.....!!! ");
    }
}
// Walking route strategy

class WalkingRoute implements RouteStrategy {
    public void navigate() {
        System.out.println("Finding shortest Walkable route.....!!! ");
    }
}

// new startegies can be added without changing client - Navigator code
class Navigator {
    String currLocation;
    String destination;
    RouteStrategy routeStrategy;

    public Navigator(String currLocation, String destination, RouteStrategy routeStrategy) {
        this.currLocation = currLocation;
        this.destination = destination;
        this.routeStrategy = routeStrategy;
    }

    public void navigate() {
        routeStrategy.navigate();
    }

    public void showRoute() {
        System.out.println("From : " + currLocation);
        System.out.println("To : " + destination);
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }
}

public class Main {
    public static void main(String args[]) {
        Navigator map = new Navigator("Narsapur", "Hyderabad", new CarRoute());

        map.navigate();
        map.showRoute();
        map.setRouteStrategy(new BikeRoute());
        // strategy is changed in run time
        map.navigate();
    }
}

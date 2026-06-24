import java.util.*;

interface NonCancellable {
    void book();
}

interface Cancellable extends NonCancellable {
    void cancel();
}

class RegularUser implements Cancellable {
    public void book() {
        System.out.println("Ticket Booked Successfully");
    }

    public void cancel() {
        System.out.println("Ticket Cancelled successfully");
    }
}

class PremiumUser implements Cancellable {
    public void book() {
        System.out.println("Ticket booked successfully");
    }

    public void cancel() {
        System.out.println("Ticket cancelled successfully");
    }
}

class GuestUser implements NonCancellable {
    public void book() {
        System.out.println("Ticket Booked Successfully");
    }
}

class Client {
    public void processNonCancellableBooking(ArrayList<NonCancellable> list) {
        for (NonCancellable user : list) {
            user.book();
        }
    }

    public void processCancellableBooking(ArrayList<Cancellable> list) {
        for (Cancellable user : list) {
            user.book();
            user.cancel();
        }
    }
}

public class Movie_Ticket_System {
    public static void main(String args[]) {
        ArrayList<NonCancellable> nonCancelList = new ArrayList<>();
        nonCancelList.add(new GuestUser());

        ArrayList<Cancellable> cancelList = new ArrayList<>();
        cancelList.add(new PremiumUser());
        cancelList.add(new RegularUser());

        Client client = new Client();
        client.processCancellableBooking(cancelList);
        client.processNonCancellableBooking(nonCancelList);

    }
}

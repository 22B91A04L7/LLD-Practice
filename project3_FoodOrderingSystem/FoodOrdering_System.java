import java.util.*;

// interface for Food Items
//follows SRP, OCP, LSP, ISP
interface FoodItem {
    void prepare();
}

// follows SRP , LSP, ISP
class Pizza implements FoodItem {
    String pizza;

    public Pizza(String pizza) {
        this.pizza = pizza;
    }

    public void prepare() {
        System.out.println(pizza + " is  Ready !!");
    }

    @Override
    public String toString() {
        return pizza;
    }

}
// follows SRP , LSP, ISP

class Burger implements FoodItem {
    String burger;

    public Burger(String burger) {
        this.burger = burger;
    }

    public void prepare() {
        System.out.println(burger + " is Ready !!");
    }

    @Override
    public String toString() {
        return burger;
    }
}
// follows SRP , LSP, ISP

class Biriyani implements FoodItem {
    String biriyani;

    public Biriyani(String biriyani) {
        this.biriyani = biriyani;
    }

    public void prepare() {
        System.out.println(biriyani + " is Ready !!");
    }

    @Override
    public String toString() {
        return biriyani;
    }
}

// acts as abstraction between OrderManager and FoodItems --> DIP
class Order {
    List<FoodItem> itemsList = new ArrayList<>();

    public void addFood(FoodItem item) {
        itemsList.add(item);
        System.out.println(item + " added to Order list");
    }

    public void prepareFood() {
        for (FoodItem item : itemsList) {
            item.prepare();
        }
    }

}

// follows SRP, OCP, LSP, ISP
interface Payment {
    void makePayment();
}

// follows SRP , LSP, ISP
class UPIPayment implements Payment {
    public void makePayment() {
        System.out.println("Paid using UPI !!");
    }
}

// follows SRP , LSP, ISP
class CashPayment implements Payment {
    public void makePayment() {
        System.out.println("Paid using Cash !!");
    }
}

// follows SRP , LSP, ISP
class CardPayment implements Payment {
    public void makePayment() {
        System.out.println("Paid using Card !!");
    }
}

// follows DIP
class OrderManager {
    Order order;
    Payment payment;

    public OrderManager(Order order, Payment payment) {
        this.order = order;
        this.payment = payment;
    }

    // adding pizza
    public void addFoodItem(FoodItem item) {
        order.addFood(item);
    }

    // preparing food
    public void prepareFood() {
        order.prepareFood();
    }

    // payment
    public void makePayment() {
        payment.makePayment();
    }
}

public class FoodOrdering_System {
    public static void main(String args[]) {
        Order order = new Order();
        Payment payment = new UPIPayment();

        OrderManager oManager = new OrderManager(order, payment);
        oManager.addFoodItem(new Pizza("Chicken Pizza"));
        oManager.addFoodItem(new Burger("KFC Burger"));
        oManager.addFoodItem(new Biriyani("Mutton Dum Biriyani"));
        oManager.prepareFood();
        oManager.makePayment();
    }
}

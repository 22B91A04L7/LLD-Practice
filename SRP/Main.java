import java.util.*;

class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {
    List<Product> products = new ArrayList<>();

    // adding products
    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    // SRP violation: calculating total price is not the responsibility of
    // ShoppingCart
    public int calculateTotalPrice() {
        int total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    // SRP violates : printing the invoice is not the responsibility of ShoppingCart
    public void printVoice() {
        System.out.println("Invoice");
        for (Product p : products) {
            System.out.println(p.name + " : " + p.price);
        }
        System.out.println("Total : " + calculateTotalPrice());
    }

}

public class Main {
    public static void main(String args[]) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 10000));
        cart.addProduct((new Product("Mobile", 50000)));
        cart.printVoice();

    }
}

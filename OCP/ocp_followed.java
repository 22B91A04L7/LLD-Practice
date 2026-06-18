import java.util.*;

class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " : " + price;
    }
}

class ShoppingCart {
    List<Product> products = new ArrayList<>();

    // adding products
    public void addProduct(Product p) {
        products.add(p);
    }

}

class ProductsPrinter {
    public List<Product> getProducts(List<Product> products) {
        System.out.println("List of Products");
        return products;
    }

}

class ProductPriceCalculator {
    // SRP -> only one responsibility --> calculating price responsibility
    public int calculateTotalPrice(List<Product> products) {
        int total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
}

class CartInvoicePrinter {
    // SRP --> only printing invoice responsibility
    public void printInVoice(List<Product> products) {
        System.out.println("Printing Invoice ...");
        int total = 0;
        for (Product p : products) {
            System.out.println(p.name + " : " + p.price);
            total += p.price;
        }
        System.out.println("Total : " + total);

    }
}

abstract class DBStorage {

    public abstract void save(ShoppingCart cart);

}

class MongoDBStorage extends DBStorage {
    public void save(ShoppingCart cart) {
        System.out.println("Saved To MOngoDB....");
    }
}

class SQLStorage extends DBStorage {
    public void save(ShoppingCart cart) {
        System.out.println("Saved To MySQL...");
    }
}

public class ocp_followed {
    public static void main(String args[]) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Iphone", 500000));
        cart.addProduct(new Product("Vivo T1 Pro", 290000));
        cart.addProduct(new Product("OPPO", 360000));

        DBStorage sql = new SQLStorage();
        DBStorage mongo = new MongoDBStorage();

        sql.save(cart);
        mongo.save(cart);
    }
}

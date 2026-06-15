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

public class Demo {
    public static void main(String args[]) {
        ShoppingCart cart = new ShoppingCart();
        // Adding Products using ShoppingCart class
        cart.addProduct(new Product("Chocolate", 150));
        cart.addProduct(new Product("Biscuit", 70));
        cart.addProduct(new Product("Drink", 50));

        // printing Products using ProductsPrinter class
        ProductsPrinter print = new ProductsPrinter();
        System.out.println(print.getProducts(cart.products));

        // calculating price using ProductPriceCalculator class
        ProductPriceCalculator calc = new ProductPriceCalculator();
        System.out.println("Total Price :" + calc.calculateTotalPrice(cart.products));

        // printing invoice using CartInvoicePrinter class
        CartInvoicePrinter invoice = new CartInvoicePrinter();
        invoice.printInVoice(cart.products);
    }
}

import java.util.*;

class Person {
    private String name;
    private String number;
    private String upiID;
    private String cardNumber;
    private String cvv;
    String bankName;

    public Person(String name, String number, String upiID, String cardNumber, String cvv,
            String bankName) {
        this.name = name;
        this.number = number;
        this.upiID = upiID;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.bankName = bankName;
    }

    public String getUpiID() {
        return upiID;
    }

    public HashMap<String, String> getCardDetails() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Card Number", cardNumber);
        map.put("CVV : ", cvv);
        return map;
    }

    public String getBankName() {
        return bankName;
    }

}

interface PaymentSystem {
    void makePayment(Person p);

}

class UPIPayment implements PaymentSystem {
    public void makePayment(Person p) {
        String upiID = p.getUpiID();
        System.out.println("Paid 500 using UPI ..");
    }
}

class CardPayment implements PaymentSystem {
    public void makePayment(Person p) {
        HashMap<String, String> details = p.getCardDetails();
        System.out.println("Paid 500 using credit card ...");
    }
}

class NetBanking implements PaymentSystem {
    public void makePayment(Person p) {
        String bank = p.getBankName();
        System.out.println("Paid 500 using Net Banking...");
    }
}

public class Payment_System {
    public static void main(String args[]) {
        Person p1 = new Person("Venkat",
                "7864384047",
                "venkat12@oksbi",
                "284648276474567",
                "865",
                "SBI");

        Person p2 = new Person(
                "Pawan",
                "9876543210",
                "pawan45@okhdfcbank",
                "512345678901234",
                "432",
                "HDFC Bank");

        Person p3 = new Person(
                "Kalyan",
                "9123456789",
                "kalyan99@okaxis",
                "678901234567890",
                "789",
                "Axis Bank");

        PaymentSystem upiPay = new UPIPayment();
        PaymentSystem cardPay = new CardPayment();
        PaymentSystem netPay = new NetBanking();

        upiPay.makePayment(p1);
        cardPay.makePayment(p2);
        netPay.makePayment(p3);
    }
}
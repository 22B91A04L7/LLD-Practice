import java.util.*;

interface Account {
    void deposit(int money);

    void withdraw(int money);
}

class SavingsAC implements Account {
    int balance;

    public SavingsAC() {
        balance = 0;
    }

    public void deposit(int money) {
        balance += money;
        System.out.println(money + " successfully deposited to Savings A/c");
    }

    public void withdraw(int money) {
        if (money <= balance) {
            balance -= money;
            System.out.println(money + " debited from Savings A/c");
        } else {
            System.out.println("Insuffient Fund ....");
        }
    }
}

class CurrentAC implements Account {
    int balance;

    public CurrentAC() {
        balance = 0;
    }

    public void deposit(int money) {
        balance += money;
        System.out.println(money + " successfully deposited to Current A/c");
    }

    public void withdraw(int money) {
        if (money <= balance) {
            balance -= money;
            System.out.println(money + " successfully debited from Current A/c");
        } else {
            System.out.println("Insuffient Fund ....");
        }
    }
}

class FixedDeposit implements Account {
    int balance;

    public FixedDeposit() {
        int balance = 0;
    }

    public void deposit(int money) {
        balance += money;
        System.out.println(money + " successfully deposited to Fixed Deposit A/c");
    }

    // LSP violated because this fixed deposit class should not contain this method
    public void withdraw(int money) {
        System.out.println("Exception : Cannot Withdraw");

    }
}

class Client {

    public void processTransaction(ArrayList<Account> list) {
        for (Account ac : list) {
            ac.deposit(500);
            ac.withdraw(200);
        }
    }
}

public class lsp_vioated {
    public static void main(String[] args) {
        Account savings = new SavingsAC();
        Account current = new CurrentAC();
        Account fixed = new FixedDeposit();

        ArrayList<Account> list = new ArrayList<>();
        list.add(savings);
        list.add(current);
        list.add(fixed);

        Client client = new Client();
        client.processTransaction(list);
    }
}